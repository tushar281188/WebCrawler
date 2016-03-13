package com.main.crawler.common.pojo;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;

	public BusinessException(String errorMessage) {
		super(errorMessage);
	}
}
