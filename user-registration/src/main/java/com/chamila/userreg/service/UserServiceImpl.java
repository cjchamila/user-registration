package com.chamila.userreg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chamila.userreg.model.User;
import com.chamila.userreg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
