package com.main.crawler.common.pojo;

import java.util.Map;

public class CrawledData {
	public Map<String, Object> crawlData;

	public Map<String, Object> getCrawlData() {
		return crawlData;
	}

	public void setCrawlData(Map<String, Object> crawlData) {
		this.crawlData = crawlData;
	}

	@Override
	public String toString() {
		return "CrawledData [crawlData=" + crawlData + "]";
	}
}