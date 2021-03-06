package io.smart.swings.basemodel.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * CheckBoxBaseTableRenderer Copyright 2016 Amit Kshirsagar
 * <amit.kshirsagar.13@gmail.com>.
 *
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * Project Name: basemodel
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

public class CheckBoxBaseTableRenderer extends JCheckBox implements TableCellRenderer {
	private final static Logger slf4j = LoggerFactory.getLogger(CheckBoxBaseTableRenderer.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax
	 * .swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (isSelected) {
			this.setBackground(getSelectedBackGroundColor());
		} else {
			if (row % 2 == 0) {
				this.setBackground(getEvenBackGroundColor());
			} else {
				this.setBackground(getOddBackGroundColor());
			}
		}
		if (obj != null) {
			setToolTipText(obj.toString());
		}
		return this;
	}

	/**
	 * @return the mOddBackGroundColor
	 */
	public Color getOddBackGroundColor() {
		return mOddBackGroundColor;
	}

	/**
	 * @param mOddBackGroundColor
	 *            the mOddBackGroundColor to set
	 */
	public void setOddBackGroundColor(Color mOddBackGroundColor) {
		this.mOddBackGroundColor = mOddBackGroundColor;
	}

	/**
	 * @return the mEvenBackGroundColor
	 */
	public Color getEvenBackGroundColor() {
		return mEvenBackGroundColor;
	}

	/**
	 * @param mEvenBackGroundColor
	 *            the mEvenBackGroundColor to set
	 */
	public void setEvenBackGroundColor(Color mEvenBackGroundColor) {
		this.mEvenBackGroundColor = mEvenBackGroundColor;
	}

	/**
	 * @return the mSelectedBackGroundColor
	 */
	public Color getSelectedBackGroundColor() {
		return mSelectedBackGroundColor;
	}

	/**
	 * @param mSelectedBackGroundColor
	 *            the mSelectedBackGroundColor to set
	 */
	public void setSelectedBackGroundColor(Color mSelectedBackGroundColor) {
		this.mSelectedBackGroundColor = mSelectedBackGroundColor;
	}

	private Color mOddBackGroundColor = new Color(242, 242, 242);
	private Color mEvenBackGroundColor = Color.WHITE;
	private Color mSelectedBackGroundColor = Color.BLUE;

}
