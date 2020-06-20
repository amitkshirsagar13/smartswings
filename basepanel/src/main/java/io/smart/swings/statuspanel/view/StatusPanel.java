package io.smart.swings.statuspanel.view;

import io.smart.swings.panel.BasePanel;
import io.smart.swings.panel.BasePanelListener;
import io.smart.swings.statuspanel.data.InfoAccessModel;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * 
 * StatusPanel Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
 *
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * Project Name: statuspanel
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
public class StatusPanel extends BasePanel implements Runnable {
	private static final long serialVersionUID = 1L;

	public StatusPanel(BasePanelListener basePanelListener) {
		super(basePanelListener, null, null);
		log.debug("Loaded statusPanel to mainFrame...");
		loadViewComponants();
	}


	private static JLabel statusBar = new JLabel();
	private JProgressBar progressBar = new JProgressBar();

	private JPanel infoPanel = new JPanel();
	private JLabel customerIndex = new JLabel();
	private JLabel readWriteLabel = new JLabel();
	private JLabel userIDLabel = new JLabel();
	private JLabel privilegedUserLabel = new JLabel();

	private void loadViewComponants() {
		customerIndex.setName("Customer Index");
		readWriteLabel.setName("Access Level");
		userIDLabel.setName("User Name");
		privilegedUserLabel.setName("Privilaged");
		statusBar.setName("Status Bar");

		customerIndex.setBorder(BorderFactory.createLoweredBevelBorder());
		readWriteLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		userIDLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		privilegedUserLabel.setBorder(BorderFactory.createLoweredBevelBorder());

		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.add(customerIndex, null);
		infoPanel.add(readWriteLabel, null);
		infoPanel.add(userIDLabel, null);
		infoPanel.add(privilegedUserLabel, null);

		setLayout(new BorderLayout());
		add(progressBar, BorderLayout.CENTER);

		progressBar.setMaximum(100);
		progressBar.setLayout(new BorderLayout());
		progressBar.setBorder(BorderFactory.createLoweredBevelBorder());
		progressBar.add(statusBar);

		add(infoPanel, BorderLayout.EAST);
		customerIndex.setText("CustomerIndex");
		readWriteLabel.setText(" R ");
		userIDLabel.setText("        ");
		privilegedUserLabel.setText(" N ");
		statusBar.setOpaque(false);
		customerIndex.setOpaque(true);
		readWriteLabel.setOpaque(true);
		userIDLabel.setOpaque(true);
		privilegedUserLabel.setOpaque(true);
		customerIndex.setToolTipText("Business Safty with Customer..");
		readWriteLabel.setToolTipText("Access For Read Write");
		userIDLabel.setToolTipText("UserID");
		privilegedUserLabel.setToolTipText("Privileged User");
		customerIndex.addMouseListener(basePanelListener);
		readWriteLabel.addMouseListener(basePanelListener);
		userIDLabel.addMouseListener(basePanelListener);
		privilegedUserLabel.addMouseListener(basePanelListener);
		statusBar.addMouseListener(basePanelListener);
		statusBar.setToolTipText("Status Bar Message...");
		setStatusMessage("Status bar working...");

	}

	String EMPTYSTRING = " ";
	String statusMessage = null;

	/**
	 * @param statusMessage
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		Thread statusThread = new Thread(this);
		statusThread.start();
	}

	public void setProgressStatus(int progressStatus, String message) {
		if (message != null) {
			setStatusMessage(EMPTYSTRING + message + EMPTYSTRING);
		}
		progressBar.setValue(progressStatus);
	}

	private void updateStatusBarMessage() {
		statusBar.setText(EMPTYSTRING + this.statusMessage + EMPTYSTRING);
	}


	private void loadInfoAccessModel(InfoAccessModel infoAccessModel) {
		customerIndex.setText(EMPTYSTRING + infoAccessModel.getIndex() + EMPTYSTRING);
		readWriteLabel.setText(EMPTYSTRING + infoAccessModel.getAccess() + EMPTYSTRING);
		userIDLabel.setText(EMPTYSTRING + infoAccessModel.getName() + EMPTYSTRING);
		privilegedUserLabel.setText(EMPTYSTRING + infoAccessModel.getRole() + EMPTYSTRING);
		setStatusMessage("InfoAccessModel updated...");
	}

	private static boolean continueMessageThread = true;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		updateStatusBarMessage();
	}
}
