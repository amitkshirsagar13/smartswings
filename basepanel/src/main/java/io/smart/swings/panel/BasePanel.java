package io.smart.swings.panel;

import io.smart.swings.basemodel.SwingsModel;
import io.smart.swings.basemodel.store.PersonRecord;
import io.smart.swings.basemodel.store.RecordsBase;
import io.smart.swings.panel.contants.BaseButtonCommands;
import io.smart.swings.panel.form.MyJTextArea;
import io.smart.swings.panel.form.MyJTextField;
import io.smart.swings.statuspanel.view.StatusPanel;
import io.smart.swings.table.BaseTable;
import io.smart.swings.x2jparser.builder.ButtonBuilder;
import io.smart.swings.x2jparser.builder.FormBuilder;
import io.smart.swings.x2jparser.builder.TableBuilder;
import io.smart.swings.x2jparser.builder.components.Button;
import io.smart.swings.x2jparser.builder.components.FormComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * 
 * 
 * BasePanel Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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
@RequiredArgsConstructor
public class BasePanel extends JPanel implements BaseButtonCommands {
	protected final BasePanelListener basePanelListener;
	private final FormBuilder formBuilder;
	private final ButtonBuilder buttonBuilder;
	private final TableBuilder tableBuilder;
	private final JPanel contentPanel;

	private JPanel infoPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel treePanel = new JPanel();
	private JPanel scaledPanel = new JPanel();
	private StatusPanel statusPanel;

	public void loadPanelOnContentPanel(String layOut) {
		contentPanel.add(this, layOut);
	}

	public void buildPanel(String panelName) {
		this.setName(panelName);
		this.setLayout(new BorderLayout());
		log.debug("Building Panel: " + panelName);
		populateInfoPanel();
		populateCenterPanel();
		populateTablePanel();
		populateButtonPanel();
		populateTreePanel();
	}

	public void populateInfoPanel() {
		infoPanel.setToolTipText("InfoPanel...");
		setBorder(infoPanel, null);
		JLabel infoLabel = new JLabel();
		infoLabel.setText("This is default InfoLabel, override your label by " + "Overriding this method...");

		infoPanel.add(infoLabel);
		this.add(infoPanel, BorderLayout.NORTH);
	}

	public void populateCenterPanel() {
		
		log.debug("Populating CenterPanel: " + getName());
		JPanel centerPanel = this.centerPanel;

		centerPanel.setToolTipText("CenterPanel...");
		this.add(this.centerPanel, BorderLayout.CENTER);

		setBorder(centerPanel, null);
		if (formBuilder.getFormComponentsForPanel(getName(), null) == null
				|| formBuilder.getFormComponentsForPanel(getName(), null).size() == 0) {
			log.debug("Populating Default FormComponants for Panel: " + getName());
			JTextField sampleTextField = new JTextField();
			sampleTextField.setText("Sample TextField");
			sampleTextField.addMouseListener(basePanelListener);
			centerPanel.add(sampleTextField);
			formComponents.put(sampleTextField.getName(), sampleTextField);
		} else {
			log.debug("Populating FormComponents for Panel: " + getName());
			addFormComponentsToPanel(centerPanel, formBuilder.getFormComponentsForPanel(getName(), null));
		}
	}
	
	private JPanel buildScaledPanel() {
		scaledPanel.setName("scaledPanel");
		scaledPanel.setLayout(new BorderLayout());

		JPanel hScale = new JPanel();
		JLabel hLabel = new JLabel();
		addMousePointInfo(hScale);
		hScale.add(hLabel);
		
		JPanel vScale = new JPanel();
		JLabel vLabel = new JLabel();
		addMousePointInfo(vScale);
		vScale.add(vLabel);
		
		JPanel centerPanel = new JPanel();
		
		scaledPanel.add(hScale, BorderLayout.NORTH);
		scaledPanel.add(vScale, BorderLayout.WEST);
		
		
		scaledPanel.add(centerPanel, BorderLayout.CENTER);
		this.centerPanel.add(scaledPanel);

		setBorder(hScale, null);
		setBorder(vScale, null);
		setBorder(centerPanel, null);
		return centerPanel;
	}
	
	private void addMousePointInfo(JPanel scalePanel) {
		
		scalePanel.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				scalePanel.setToolTipText(getMousePointInfo(scalePanel));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				scalePanel.setToolTipText(getMousePointInfo(scalePanel));
			}
		});
	}
	
	private String getMousePointInfo(JPanel scalePanel) {
		return "";
	}

	public void populateButtonPanel() {
		buttonPanel.setToolTipText("ButtonPanel...");
		setBorder(buttonPanel, null);
		if (buttonBuilder.getButtonsForPanel(getName()) == null
				|| buttonBuilder.getButtonsForPanel(getName()).size() == 0) {
			log.debug("Populating Default Buttons for Panel: " + getName());
			JButton okButton = new JButton(OK);
			okButton.setName(okButton.getText());
			okButton.setActionCommand(okButton.getName());
			okButton.addActionListener(basePanelListener);
			buttonPanel.add(okButton);
			buttons.put(okButton.getName(), okButton);
		} else {
			log.debug("Populating Buttons for Panel: " + getName());
			addButtonsToPanel(buttonPanel, "Default", buttonBuilder.getButtonsForPanel(getName()));
		}
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void populateTablePanel() {buttonPanel.setToolTipText("ButtonPanel...");
		setBorder(tablePanel, null);
		if (tableBuilder.getTablesForPanel(getName()) != null
				|| tableBuilder.getTablesForPanel(getName()).size() > 0) {
			log.debug("Populating Table for Panel: " + getName());
			tableBuilder
			.getTablesForPanel(getName())
			.stream()
			.forEach(table -> {
				Vector<PersonRecord> recordsList = new Vector<>();
				Vector columns = new Vector();
				PersonRecord personRecord = PersonRecord.builder().name("Name").place("Place").role("Role").id("ID").build();
				recordsList.add(personRecord);
				columns.add(personRecord.getRecordVector());
				SwingsModel swingsModel = new SwingsModel(recordsList, personRecord.getRecordVector());
				BaseTable baseTable = new BaseTable(swingsModel);
				JScrollPane scrollPanel = baseTable.getScrollPanel();
				scrollPanel
						.setSize(Integer.parseInt(table.getComponentWidth()),
								Integer.parseInt(table.getComponentHeight()));
				baseTable.populateTable();

				JPanel tablePanel = new JPanel();
				tablePanel.setSize(Integer.parseInt(table.getComponentWidth()),
						Integer.parseInt(table.getComponentHeight()));
				tablePanel.add(scrollPanel);
				this.add(tablePanel, BorderLayout.EAST);
			});
		}
	}

	public void populateTreePanel() {
		treePanel.setToolTipText("TreePanel...");
		setBorder(treePanel, null);
		this.add(treePanel, BorderLayout.WEST);
	}

	private void setBorder(JPanel panel, Border borderType) {
		if (borderType == null) {
			borderType = BorderFactory.createLoweredBevelBorder();
		}
		panel.setBorder(borderType);
	}

	/**
	 * @return the infoPanel
	 */
	public JPanel getInfoPanel() {
		return infoPanel;
	}

	/**
	 * @return the centerPanel
	 */
	public JPanel getCenterPanel() {
		return centerPanel;
	}

	/**
	 * @return the resultPanel
	 */
	public JPanel getTablePanel() {
		return tablePanel;
	}

	/**
	 * @return the buttonPanel
	 */
	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	/**
	 * @return the treePanel
	 */
	public JPanel getTreePanel() {
		return treePanel;
	}


	/**
	 * @param controlPanel
	 * @param buttonList
	 */
	public void addButtonsToPanel(JPanel controlPanel, String toolbarName, List<Button> buttonList) {
		JPanel toolbar = new JPanel();
		toolbar.setName(toolbarName);
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		for (int i = 0; i < buttonList.size(); i++) {
			Button button = buttonList.get(i);
			if (!buttons.containsKey(button.getButtonAction())) {
				JButton jButton = new JButton(button.getButtonName());
				jButton.setName(button.getButtonName());
				jButton.setActionCommand(button.getButtonAction());
				jButton.addActionListener(basePanelListener);
				jButton.setToolTipText(button.getButtonToolTip());
				if (button.getButtonDisabled() != null && button.getButtonDisabled().equalsIgnoreCase("Disabled")) {
					jButton.setEnabled(false);
				}

				if (button.getButtonListeners() != null) {
					if (button.getButtonListeners().contains("FocusListener")) {
						jButton.addFocusListener(basePanelListener);
					}
					if (button.getButtonListeners().contains("MouseListener")) {
						jButton.addMouseListener(basePanelListener);
					}
				}
				buttons.put(jButton.getActionCommand(), jButton);
				toolbar.add(jButton);
			}
			toolbar.setToolTipText(toolbarName);
			controlPanel.add(toolbar);
			JSeparator toolbarSeparator = new JSeparator();
			Dimension d = toolbarSeparator.getPreferredSize();
			d.height = toolbar.getPreferredSize().height;
			d.width = 1;
			toolbarSeparator.setPreferredSize(d);
			toolbarSeparator.setOrientation(SwingConstants.VERTICAL);
			controlPanel.add(toolbarSeparator);
		}

	}

	public void addFormComponentsToPanel(JPanel controlPanel, List<FormComponent> formComponentList) {
		controlPanel.setLayout(null);
		for (int i = 0; i < formComponentList.size(); i++) {
			FormComponent formComponent = formComponentList.get(i);
			if (!formComponents.containsKey(formComponent.getComponentName())) {
				JComponent jComponent = prepareFormComponent(controlPanel, formComponent);
				formComponents.put(jComponent.getName(), jComponent);
			}
		}

	}

	public JComponent prepareFormComponent(JPanel controlPanel, FormComponent formComponent) {
		JComponent jComponent = null;
		if (formComponent.getComponentType().equalsIgnoreCase("JTextField")) {
			jComponent = new MyJTextField(formComponent.getComponentName());
			if (formComponent.getComponentDisabled() != null
					&& formComponent.getComponentDisabled().equalsIgnoreCase("Disabled")) {
				jComponent.setEnabled(false);
			}
			if (formComponent.getComponentListeners() != null) {
				if (formComponent.getComponentListeners().contains("FocusListener")) {
					jComponent.addFocusListener(basePanelListener);
				}
				if (formComponent.getComponentListeners().contains("MouseListener")) {
					jComponent.addMouseListener(basePanelListener);
				}
			}
			((MyJTextField) jComponent).setHighLightColor(formComponent.getHighLightColor());
			((MyJTextField) jComponent).setValidationPattern(formComponent.getValidationPattern());
		} else if (formComponent.getComponentType().equalsIgnoreCase("JTextArea")) {
			jComponent = new MyJTextArea(formComponent.getComponentName());
			if (formComponent.getComponentDisabled() != null
					&& formComponent.getComponentDisabled().equalsIgnoreCase("Disabled")) {
				jComponent.setEnabled(false);
			}
			if (formComponent.getComponentListeners() != null) {
				if (formComponent.getComponentListeners().contains("FocusListener")) {
					jComponent.addFocusListener(basePanelListener);
				}
				if (formComponent.getComponentListeners().contains("MouseListener")) {
					jComponent.addMouseListener(basePanelListener);
				}
			}
			((MyJTextArea) jComponent).setHighLightColor(formComponent.getHighLightColor());
			((MyJTextArea) jComponent).setValidationPattern(formComponent.getValidationPattern());
			if (formComponent.getRows()!=null) {
				((MyJTextArea) jComponent).setRows(formComponent.getRows().intValue());
			}
		} else if (formComponent.getComponentType().equalsIgnoreCase("JLabel")) {
			jComponent = new JLabel(formComponent.getComponentToolTip().toString());

			((JLabel) jComponent).setBackground(hexToColor(formComponent.getHighLightColor()));
			if (hexToColor(formComponent.getHighLightColor()) != null ) {
				((JLabel) jComponent).setOpaque(true);
			}
		} else if (formComponent.getComponentType().equalsIgnoreCase("JComboBox")) {
			JComboBox jComponent2 = new JComboBox();
			jComponent2.addItemListener(basePanelListener);
			jComponent = jComponent2;
		}
		jComponent.setName(formComponent.getComponentName());
		jComponent.setToolTipText(formComponent.getComponentToolTip().toString());

		int width = 0;
		int height = 0;
		try {
			if (formComponent.getComponentWidth() != null && !formComponent.getComponentWidth().equalsIgnoreCase("")) {
				width = Integer.parseInt(formComponent.getComponentWidth());
			}
			if (formComponent.getComponentHeight() != null && !formComponent.getComponentHeight().equalsIgnoreCase("")) {
				height = Integer.parseInt(formComponent.getComponentHeight());
			}
		} catch (Exception e) {
			log.error("Failed processing formComponent width/height: " + formComponent.getComponentName() + ":"
					+ e.getMessage());
		}

		jComponent.setBounds(Integer.parseInt(formComponent.getComponentXPos()),
				Integer.parseInt(formComponent.getComponentYPos()), width == 0 ? 250 : width, height == 0 ? 30 : height);
		JScrollPane jScPanel = null;

		if(formComponent.isHscroll()!=null || formComponent.isVscroll()!=null) {
			jScPanel = new JScrollPane(jComponent);
			jScPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jScPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			jScPanel.setName(formComponent.getComponentName());
			jScPanel.setBounds(Integer.parseInt(formComponent.getComponentXPos()),
					Integer.parseInt(formComponent.getComponentYPos()), width == 0 ? 250 : width, height == 0 ? 50 : height);
			jScPanel.setPreferredSize(new Dimension(width == 0 ? 250 : width, height == 0 ? 50 : height));
		}

		if (jScPanel == null) {
			controlPanel.add(jComponent);
		} else {
			controlPanel.add(jScPanel);
		}

		return jComponent;
	}

	protected HashMap<String, JComponent> formComponents = new HashMap<String, JComponent>();
	protected HashMap<String, JButton> buttons = new HashMap<String, JButton>();

	public HashMap<String, JButton> getButtons() {
		return buttons;
	}
	/**
	 * @return the formComponents
	 */
	public HashMap<String, JComponent> getFormComponents() {
		return formComponents;
	}

	public JComponent getFormComponent(String key) {
		JComponent jComponent = formComponents.get(key);
		if (jComponent instanceof JScrollPane) {
			return (JComponent) ((JScrollPane)jComponent).getComponent(0);
		}
		return jComponent;
	}

	public static Color hexToColor(String hex) {
		if (hex != null) {
			hex = hex.replace("#", "");
			switch (hex.length()) {
				case 6:
					return new Color(Integer.valueOf(hex.substring(0, 2), 16), Integer.valueOf(hex.substring(2, 4), 16),
							Integer.valueOf(hex.substring(4, 6), 16));
				case 8:
					return new Color(Integer.valueOf(hex.substring(0, 2), 16), Integer.valueOf(hex.substring(2, 4), 16),
							Integer.valueOf(hex.substring(4, 6), 16), Integer.valueOf(hex.substring(6, 8), 16));
			}
		}
		return null;
	}

	public StatusPanel getStatusPanel() {
		return statusPanel;
	}

	public void setStatusPanel(StatusPanel statusPanel) {
		this.statusPanel = statusPanel;
	}

	private void setStatusMessage(String statusMessage) {
		statusPanel.setStatusMessage(statusMessage);
	}

	private void setProgressStatus(int progressStatus, String statusMessage) {
		statusPanel.setProgressStatus(progressStatus, statusMessage);
	}
}
