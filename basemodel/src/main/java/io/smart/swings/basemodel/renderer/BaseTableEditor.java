package io.smart.swings.basemodel.renderer;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * BaseTableEditor Copyright 2016 Amit Kshirsagar
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

@Slf4j
public class BaseTableEditor extends DefaultCellEditor {

	public BaseTableEditor(String[] items) {
		super(new JComboBox(items));
	}

}
