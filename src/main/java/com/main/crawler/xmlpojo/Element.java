package com.main.crawler.xmlpojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class Element {
	private String key;
	private String selectQuery;
	private String parentQuery;
	private String index;
	private boolean hrefLink;

	private List<Element> element;

	private Integer templateIterationCount;

	@XmlAttribute
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@XmlAttribute
	public String getSelectQuery() {
		return selectQuery;
	}

	public void setSelectQuery(String selectQuery) {
		this.selectQuery = selectQuery;
	}

	@XmlAttribute
	public String getParentQuery() {
		return parentQuery;
	}

	public void setParentQuery(String parentQuery) {
		this.parentQuery = parentQuery;
	}

	public List<Element> getElement() {
		return element;
	}

	public void setElement(List<Element> element) {
		this.element = element;
	}

	@XmlAttribute
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@XmlAttribute
	public boolean isHrefLink() {
		return hrefLink;
	}

	public void setHrefLink(boolean hrefLink) {
		this.hrefLink = hrefLink;
	}

	@XmlAttribute
	public Integer getTemplateIterationCount() {
		return templateIterationCount;
	}

	public void setTemplateIterationCount(Integer templateIterationCount) {
		this.templateIterationCount = templateIterationCount;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof Element))
			return false;

		Element element = (Element) o;
		return key.equalsIgnoreCase(element.key);
	}

}