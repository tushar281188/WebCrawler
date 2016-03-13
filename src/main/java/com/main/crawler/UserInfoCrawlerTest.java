package com.main.crawler;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.main.crawler.UserInfoCrawler;
import com.main.crawler.common.pojo.BusinessException;
import com.main.crawler.common.pojo.CrawledData;
import com.main.crawler.parsers.XmlParser;
import com.main.crawler.utils.CommonUtil;
import com.main.crawler.xmlpojo.Crawler;

public class UserInfoCrawlerTest {
	public static void main(String[] args) throws BusinessException {
		Document doc;
		try {

			if (args[0] == "") {
				throw new BusinessException("Provide xml template");
			}

			if (args[1] == "") {
				throw new BusinessException("Provide profile URL");
			}

			XmlParser xmlFileParser = new XmlParser();
			File file = new File(args[0]);

			Crawler adFeedsIntegrator;
			try {
				adFeedsIntegrator = xmlFileParser.parse(file, Crawler.class);
			} catch (BusinessException e1) {
				return;
			}

			if (null == adFeedsIntegrator) {
				return;
			}

			doc = Jsoup.connect(args[1]).get();

			UserInfoCrawler linkedInCrawler = new UserInfoCrawler();
			CrawledData crawledData = linkedInCrawler.crawl(doc,
					adFeedsIntegrator);

			CommonUtil commonUtil = new CommonUtil();
			try {
				String crawlDataInJsonFormat = commonUtil
						.writeResponseAsString(crawledData);

				System.out.println(crawlDataInJsonFormat);

			} catch (BusinessException e) {
				return;
			}

		} catch (IOException e) {
			throw new BusinessException(
					"Exception while performing crawling operation, root cause: "
							+ e.getMessage());
		}
	}
}