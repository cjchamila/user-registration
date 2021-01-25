package com.chamila.userreg.service;

import java.util.List;

import com.chamila.userreg.model.Country;
import com.chamila.userreg.model.State;

public interface CountryService {

	public List<Country> findCountries();
	
	public List<State> findStates(String countryName);
	
	public List<State>findStates();
	
	
}
