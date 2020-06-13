package io.smart.swings.basemodel;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smart.swings.basemodel.store.RecordsBase;

/**
 * 
 * 
 * SwingsModel Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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

public class SwingsModel extends DefaultTableModel {
	private final static Logger slf4j = LoggerFactory.getLogger(SwingsModel.class);

	public SwingsModel(Vector<RecordsBase> recordsList, Vector columns) {

		super();
		Vector<Vector> filteredRecordsList = new Vector<Vector>();
		for (Iterator<RecordsBase> iterator = recordsList.iterator(); iterator.hasNext();) {
			RecordsBase recordBase = iterator.next();
			Vector vector = recordBase.getRecordVector();
			filteredRecordsList.add(vector);
		}

		this.setDataVector(filteredRecordsList, columns);
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return (getValueAt(0, column).getClass());
	}
}