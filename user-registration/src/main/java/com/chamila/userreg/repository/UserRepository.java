package com.chamila.userreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.chamila.userreg.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
//	@Procedure("saveUser")
//	public User saveUserDetails(String addr1,String addr2,String city,int zipcode,String country,String name,int phone,String state,int userId);


}
