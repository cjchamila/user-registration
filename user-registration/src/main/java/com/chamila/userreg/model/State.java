package com.chamila.userreg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(name = "State.findStatesForCountry", 
procedureName = "findStatesForCountry", parameters = {
@StoredProcedureParameter(mode = ParameterMode.IN, name = "country_name", type = String.class)  })
public class State {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	
	public State() {}
	
	public State(String name) {
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
