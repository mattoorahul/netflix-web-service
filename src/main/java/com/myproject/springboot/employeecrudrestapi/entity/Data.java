package com.myproject.springboot.employeecrudrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "netflix")
public class Data {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "show_id")
	private String show_id;

	@Column(name = "type")
	private String type;

	@Column(name = "country")
	private String country;

	@Column(name = "date_added")
	private String date_added;

	@Column(name = "listed_in")
	private String listed_in;

	// define constructors

	public Data() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShow_id() {
		return show_id;
	}

	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public String getListed_in() {
		return listed_in;
	}

	public void setListed_in(String listed_in) {
		this.listed_in = listed_in;
	}

	public Data(int id, String show_id, String type, String country, String date_added, String listed_in) {
		super();
		this.id = id;
		this.show_id = show_id;
		this.type = type;
		this.country = country;
		this.date_added = date_added;
		this.listed_in = listed_in;
	}

}
