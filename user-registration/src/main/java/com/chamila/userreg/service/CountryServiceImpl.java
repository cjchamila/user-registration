package com.chamila.userreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chamila.userreg.model.Country;
import com.chamila.userreg.model.State;
import com.chamila.userreg.repository.CountryRepository;
import com.chamila.userreg.repository.StateRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Override
	public List<Country> findCountries() {
		// TODO Auto-generated method stub
		return countryRepo.findAll();
	}

	@Override
	public List<State> findStates(String countryName) {
		// TODO Auto-generated method stub
		return stateRepo.findStatesForCountry(countryName);
	}

	@Override
	public List<State> findStates() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

	

}
