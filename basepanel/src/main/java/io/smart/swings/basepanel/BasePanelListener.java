package io.smart.swings.basepanel;

import io.smart.swings.basepanel.contants.BaseButtonCommands;
import io.smart.swings.basepanel.form.MyJTextField;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * 
 * 
 * BasePanelListener Copyright 2016 Amit Kshirsagar
 * <amit.kshirsagar.13@gmail.com>.
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
public abstract class BasePanelListener extends JPanel
		implements ActionListener, FocusListener, MouseListener, BaseButtonCommands, ItemListener {


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent event) {
		if (event.getSource().getClass().getName().contains("Label")) {
			if (event.getClickCount() == 2) {
				JOptionPane.showMessageDialog(this,
						((JLabel) event.getSource()).getName() + " : " + ((JLabel) event.getSource()).getText(),
						((JLabel) event.getSource()).getName(), JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (event.getSource().getClass().getName().contains("TextField")) {
			if (event.getClickCount() == 3) {
				((JTextField) event.getSource()).setText("");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */

	public void mousePressed(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */

	public void mouseReleased(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */

	public void mouseEntered(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */

	public void mouseExited(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */

	public void focusGained(FocusEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */

	public void focusLost(FocusEvent e) {
		validateFormField(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	public void actionPerformed(final ActionEvent event) {
		final String command = event.getActionCommand();
		Runnable actionRunner = () -> {
			if (command.equalsIgnoreCase(OK)) {
				executeOK();
			} else if (command.equalsIgnoreCase(SUBMIT)) {
				executeSubmit();
			} else if (command.equalsIgnoreCase(CANCEL)) {
				executeCancel();
			} else if (command.equalsIgnoreCase(RESET)) {
				executeReset();
			} else {
				if(!executeButtonAction(command)){
					executeNoActionMessage(event);
				}
			}
		};

		Thread actionThread = new Thread(actionRunner, event.getSource().toString());
		actionThread.start();
	}

	private void validateFormField(FocusEvent e) {
		try {
			if (e.getComponent() instanceof MyJTextField
					&& isNotEmpty(((MyJTextField) e.getComponent()).getValidationPattern())) {
				String validationPattern = ((MyJTextField) e.getComponent()).getValidationPattern();
				String value = ((MyJTextField) e.getComponent()).getText();
				if (!Pattern.compile(validationPattern).matcher(value).matches()) {
					if (isNotEmpty(((MyJTextField) e.getComponent()).getHighLightColor())) {
						((MyJTextField) e.getComponent())
								.setBackground(Color.decode(((MyJTextField) e.getComponent()).getHighLightColor()));
					} else {
						((MyJTextField) e.getComponent()).setBackground(Color.RED);
					}
					((MyJTextField) e.getComponent()).setToolTipText(validationPattern);
				} else {
					((MyJTextField) e.getComponent()).setBackground(Color.WHITE);
				}
			}
		} catch (Exception exc) {
			log.error("Message Here", exc);
		}
	}

	/**
	 * @param validationPattern
	 * @return
	 */
	private boolean isNotEmpty(String validationPattern) {
		if (validationPattern != null && !validationPattern.equalsIgnoreCase("")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public void executeNoActionMessage(ActionEvent event) {
		buttonWithOutAction(event);
	}

	/**
	 * 
	 */
	public void executeReset() {
		log.debug("Executing Reset");
	}

	/**
	 * 
	 */
	public void executeCancel() {
		log.debug("Executing Cancel");
	}

	/**
	 * 
	 */
	public void executeSubmit() {
		log.debug("Executing Submit");
	}

	/**
	 * 
	 */
	public void executeOK() {
		log.debug("Executing OK");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void delayMe(long sleep) {
		try {
			Thread.currentThread().sleep(sleep);
		} catch (InterruptedException e) {
		}
	}

	public boolean executeButtonAction(String actionName){
		boolean executed = false;
		return executed;
	}

	public void buttonWithOutAction(ActionEvent event) {
		String message = ((JComponent) event.getSource()).getName() + " : " + "Button without action: Modify class "
				+ this.getClass().getName() + " to add action logic...";
		JOptionPane.showMessageDialog(this.getParent(),
				message,
				((JComponent) event.getSource()).getName(), JOptionPane.INFORMATION_MESSAGE);
		log.warn(message);

	}

}
