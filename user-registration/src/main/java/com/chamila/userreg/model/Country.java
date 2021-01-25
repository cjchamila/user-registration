package com.chamila.userreg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Country {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	public Country() {}
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="country_id")
	private List<State>states=new ArrayList<State>();

	public Country(String country) {
		this.name=country;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<State> getStates() {
		return states;
	}


	public void setStates(List<State> states) {
		this.states = states;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
