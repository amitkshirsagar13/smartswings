package io.smart.swings.x2jparser.builder;

import io.smart.swings.x2jparser.builder.components.Button;
import io.smart.swings.x2jparser.builder.components.Panel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 
 * 
 * ButtonBuilder Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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
public class ButtonBuilder {
	private final JComponentBuilder jComponentBuilder;

	public List<Button> getButtonsForPanel(String panelName) {
		Optional<Panel> optionalPanel = jComponentBuilder.getApplication()
				.getFrame()
				.getPanel()
				.stream()
				.filter(panel -> panel.getPanelName().equalsIgnoreCase(panelName)).findFirst();
		return optionalPanel.isPresent()? optionalPanel.get().getButton() : new ArrayList<>();
	}

}
