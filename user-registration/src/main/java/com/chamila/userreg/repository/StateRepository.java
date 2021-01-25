package com.chamila.userreg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.chamila.userreg.model.State;

public interface StateRepository extends JpaRepository<State, Integer>{

//	@Query(name = "select name from state where country_id=(select id from country where name =?1)",nativeQuery = true)
//	public List<State>findStatesForCountry(String countryName);
	
	@Procedure(procedureName = "findStatesForCountry")
	public List<State> findStatesForCountry(String country_name);
	
	/*
	 * @Query(value = "CALL findStatesForCountry(:country_name)", nativeQuery =
	 * true) public List<State>findStatesForCountry(@Param("country_name") String
	 * countryName);
	 */
	
}
