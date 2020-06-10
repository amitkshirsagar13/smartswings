package io.smart.swings.x2jparser.builder;

import io.smart.swings.x2jparser.builder.components.FormComponent;
import io.smart.swings.x2jparser.builder.components.Panel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 
 * 
 * FormBuilder Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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
@Slf4j
@RequiredArgsConstructor
public class FormBuilder {
	private final JComponentBuilder jComponentBuilder;

	public List<FormComponent> getFormComponentsForPanel(String panelName, String subPanelName) {
		Optional<Panel> optionalPanel = jComponentBuilder.getApplication()
				.getFrame()
				.getPanel()
				.stream()
				.filter(
						panel -> panel.getPanelName().equalsIgnoreCase(panelName)
								&& (panel.getSubPanelName().equalsIgnoreCase(subPanelName)
								|| StringUtils.isEmpty(subPanelName)))
				.findFirst();
		return optionalPanel.isPresent()? optionalPanel.get().getFormComponent() : new ArrayList<>();
	}

}
