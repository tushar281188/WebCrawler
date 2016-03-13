package com.main.crawler.parsers;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.main.crawler.common.pojo.BusinessException;

public class XmlParser {

	@SuppressWarnings({ "unchecked", "restriction" })
	public <T> T parse(String xmlString, Class<?> clazz)
			throws BusinessException {
		T pojoRepresentation = null;

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(xmlString);
			pojoRepresentation = (T) jaxbUnmarshaller
					.unmarshal(new StreamSource(reader));

		} catch (JAXBException e) {
			throw new BusinessException("Error while initializing jaxbContext");

		} catch (Throwable t) {
			throw new BusinessException(
					"Exception while parsing mapping xml contents pojo");
		}

		return pojoRepresentation;
	}

	@SuppressWarnings({ "unchecked", "restriction" })
	public <T> T parse(File file, Class<?> clazz) throws BusinessException {
		T pojoRepresentation = null;

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			pojoRepresentation = (T) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			throw new BusinessException("Error while initializing jaxbContext");

		} catch (Throwable t) {
			throw new BusinessException(
					"Exception while parsing mapping xml contents pojo");
		}

		return pojoRepresentation;
	}
}