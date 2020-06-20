package io.smart.swings.panel.form;

import javax.swing.JTextArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * MyJTextField Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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

public class MyJTextArea extends JTextArea {

	/**
	 * log4j object for debugging.
	 */
	private final static Logger slf4j = LoggerFactory.getLogger(MyJTextArea.class);

	public MyJTextArea(String pName) {
		super(pName);
	}

	private String validationPattern;
	private String highLightColor;
	private boolean valid;

	/**
	 * @return the highLightColor
	 */
	public String getHighLightColor() {
		return highLightColor;
	}

	/**
	 * @param highLightColor
	 *            the highLightColor to set
	 */
	public void setHighLightColor(String highLightColor) {
		this.highLightColor = highLightColor;
	}

	/**
	 * @return the validationPattern
	 */
	public String getValidationPattern() {
		return validationPattern;
	}

	/**
	 * @param validationPattern
	 *            the validationPattern to set
	 */
	public void setValidationPattern(String validationPattern) {
		this.validationPattern = validationPattern;
	}

	/**
	 * @return the valid
	 */
	@Override
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
