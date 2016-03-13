package com.main.crawler.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.crawler.common.pojo.BusinessException;

public class CommonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	public <T> String writeResponseAsString(T responseObject)
			throws BusinessException {
		String responseJsonString = "";

		try {
			responseJsonString = mapper.writeValueAsString(responseObject);
		} catch (Throwable t) {
			throw new BusinessException(
					"Exception while Parsing data to String");
		}

		return responseJsonString;
	}
}
