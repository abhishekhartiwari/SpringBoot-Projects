package com.abhi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.dao.UserRepository;
import com.abhi.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	

	public List<User> getServiceAllUsers() {
		List<User> user =  new ArrayList<>();
		userRepository.findAll().forEach(user :: add);
		return user;
	}
	
	public Optional<User> getServiceUser(int userId) {
		return userRepository.findById(userId);
	}
	
	public void addServiceUser(User user) {
		userRepository.save(user);
	}
	
	public void updateServiceUser(int userId, User user) {
		userRepository.save(user);
	}

	public void deleteServiceUser(int userId) {
		userRepository.deleteById(userId);
	}


}
