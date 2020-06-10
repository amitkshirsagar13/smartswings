package io.smart.swings.toolpanel;

import io.smart.swings.basepanel.BasePanel;
import io.smart.swings.basepanel.BasePanelListener;
import io.smart.swings.x2jparser.builder.components.Button;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * ToolbarPanel Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
 *
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * Project Name: basepanel
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
public class ToolbarPanel extends BasePanel {

	public ToolbarPanel(BasePanelListener basePanelListener, ToolbarConfiguration toolbarConfiguration) {
		super(basePanelListener, null, null);
		this.setName("TOOLBARPANEL");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		if (isToolbarAvailable(toolbarConfiguration)) {
			toolbarConfiguration
					.toolbarListMap
					.entrySet()
					.stream()
					.forEach(menu-> loadToolBarButtons(menu.getKey(), menu.getValue()));
		} else {
			Button devButton = new Button();
			devButton.setButtonAction("DEV");
			devButton.setButtonName("Dev");
			devButton.setButtonToolTip("Run Dev Action");
			List<Button> buttonList = Arrays.asList(devButton);
			loadToolBarButtons("DemoTools", buttonList);
		}
	}

	private void loadToolBarButtons(String menuName, List<Button> buttonList) {
		addButtonsToPanel(this, menuName, buttonList);
	}

	private boolean isToolbarAvailable(ToolbarConfiguration toolbarConfiguration) {
		return toolbarConfiguration!=null
				&& toolbarConfiguration.toolbarListMap !=null
				&& toolbarConfiguration.toolbarListMap.size()>0;
	}
}
