package com.chamila.userreg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chamila.userreg.model.Country;
import com.chamila.userreg.model.State;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
