package com.main.crawler;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.main.crawler.common.pojo.CrawledData;
import com.main.crawler.xmlpojo.Crawler;
import com.main.crawler.xmlpojo.Element;

public class UserInfoCrawler {

	public CrawledData crawl(Document doc, Crawler crawler) {
		CrawledData crawledData = new CrawledData();

		if (null == crawledData.getCrawlData()) {
			crawledData.setCrawlData(new HashMap<String, Object>());
		}

		for (Element element : crawler.getElementList()) {
			Integer iterationCount = element.getTemplateIterationCount();

			if (null != iterationCount) {
				Map<Integer, Map<String, String>> map = new HashMap<Integer, Map<String, String>>();

				for (int i = 0; i < iterationCount; i++) {
					element.setIndex(String.valueOf(i));
					Map<String, String> crawlDataMap = crawl(doc, element,
							crawledData);

					map.put(i, crawlDataMap);
				}

				crawledData.getCrawlData().put(element.getKey(), map);

			} else {
				Map<String, String> crawlDataMap = crawl(doc, element,
						crawledData);
				crawledData.getCrawlData().put(element.getKey(), crawlDataMap);
			}
		}

		return crawledData;
	}

	public Map<String, String> crawl(Document doc, Element element,
			CrawledData crawledData) {

		Map<String, String> localMap = new HashMap<String, String>();

		if (null != element.getElement() && !element.getElement().isEmpty()) {
			for (Element childElement : element.getElement()) {

				String key = childElement.getKey();
				String selectQuery = childElement.getSelectQuery();

				String parentQuery = childElement.getParentQuery();
				if (null == parentQuery || parentQuery == "") {
					if (null != element.getParentQuery()
							&& element.getParentQuery() != "") {
						parentQuery = element.getParentQuery();
					}
				}

				String index = childElement.getIndex();
				if (null == index || index == "") {
					if (null != element.getIndex() && element.getIndex() != "") {
						index = element.getIndex();
					}
				}

				boolean hrefLink = childElement.isHrefLink();
				String correspondingJsoupValue = getValue(doc, key,
						selectQuery, parentQuery, index, hrefLink);

				localMap.put(key, correspondingJsoupValue);
			}

		} else {
			String correspondingJsoupValue = getValue(doc, element.getKey(),
					element.getSelectQuery(), element.getParentQuery(),
					element.getIndex(), element.isHrefLink());

			localMap.put(element.getKey(), correspondingJsoupValue);
		}

		return localMap;
	}

	private String getValue(Document doc, String key, String selectQuery,
			String parentQuery, String index, boolean hrefLink) {

		String correspondingJsoupValue = null;
		Elements jsoupSection = null;
		if (index != null && index != "") {
			jsoupSection = doc.select(parentQuery).get(Integer.parseInt(index))
					.select(selectQuery);

		} else {
			String masterSelectQuery = parentQuery + " " + selectQuery;
			jsoupSection = doc.select(masterSelectQuery);
		}

		correspondingJsoupValue = jsoupSection.text();
		if (hrefLink) {
			correspondingJsoupValue = correspondingJsoupValue + "::"
					+ jsoupSection.select(" a").attr("href");
		}

		return correspondingJsoupValue;
	}
}