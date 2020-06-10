package io.smart.swings.x2jparser.builder;

import io.smart.swings.x2jparser.builder.components.Application;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * 
 * 
 * JComponentBuilder Copyright 2016 Amit Kshirsagar
 * <amit.kshirsagar.13@gmail.com>.
 *
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * Project Name: x2jparser
 * Creation date: Aug 14, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Data
@Slf4j
@RequiredArgsConstructor
public class JComponentBuilder {
	private final String applicationComponentXml;
	private Application application;

	@PostConstruct
	private void parseDom2Components() {
		if (StringUtils.isNotEmpty(applicationComponentXml)) {
			if (application == null) {
				try {
					File componentXml = new ClassPathResource(applicationComponentXml).getFile();
					JAXBContext jaxbContext = JAXBContext.newInstance(Application.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					application = (Application) jaxbUnmarshaller.unmarshal(componentXml);
				} catch (JAXBException | IOException e) {
					log.error("Failed to parse the Component Configuration!!!", e);
				}
			}
		} else {
			log.error("ComponentConfigurationXml not defined");
		}

	}

}
