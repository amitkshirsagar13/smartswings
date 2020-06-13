package io.smart.swings.basemodel.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * BaseRecord Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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

public class BaseRecord extends RecordsBase {

	/**
	 * log4j object for debugging.
	 */
	private final static Logger slf4j = LoggerFactory.getLogger(BaseRecord.class);

	Map<String, Object> baseDetails = new HashMap<String, Object>();

	/**
	 * @return the orderDetails
	 */
	public Map<String, Object> getBaseDetails() {
		return baseDetails;
	}

	/**
	 * @param orderDetails
	 *            the orderDetails to set
	 */
	public void setBaseDetails(Map<String, Object> recordDetails) {
		this.baseDetails = recordDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sample.base.model.RecordBase#getRecordVector()
	 */
	@Override
	public Vector getRecordVector() {
		for (Object object : baseDetails.values()) {
			this.add(object);
		}
		return this;
	}

}
