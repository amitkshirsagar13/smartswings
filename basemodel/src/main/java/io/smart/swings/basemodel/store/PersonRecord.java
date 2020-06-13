package io.smart.swings.basemodel.store;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * PersonRecord Copyright 2016 Amit Kshirsagar <amit.kshirsagar.13@gmail.com>.
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

public class PersonRecord extends RecordsBase {
	private final static Logger slf4j = LoggerFactory.getLogger(PersonRecord.class);

	/**
	 * 
	 */
	public PersonRecord(String id, String name, String place, String role) {
		this.id = id;
		this.name = name;
		this.place = place;
		this.role = role;
	}

	private String id = null;
	private String name = null;
	private String place = null;
	private String role = null;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sample.base.model.RecordBase#getRecordVector()
	 */
	@Override
	public Vector getRecordVector() {
		this.add(id);
		this.add(name);
		this.add(place);
		this.add(role);
		return this;
	}

}
