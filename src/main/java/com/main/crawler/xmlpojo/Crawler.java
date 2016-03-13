package com.main.crawler.xmlpojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "linkedInCrawler")
@XmlAccessorType(XmlAccessType.FIELD)
public class Crawler {

	@XmlElement(name = "element")
	private List<Element> elementList;

	public List<Element> getElementList() {
		return elementList;
	}

	public void setElementList(List<Element> elementList) {
		this.elementList = elementList;
	}
}