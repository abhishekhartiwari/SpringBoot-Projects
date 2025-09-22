package com.abhishek.journalApp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.abhishek.journalApp.entity.JournalEntity;
import com.abhishek.journalApp.entity.UserEntity;
import com.abhishek.journalApp.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	PasswordEncoder pe = new BCryptPasswordEncoder();
	//create document in collection in mongo DB
	
	public void createUser(UserEntity jou) {
		
		jou.setPassword(pe.encode(jou.getPassword()));
		jou.setRoles(Arrays.asList("USER"));
		userRepo.save(jou);
	}
	
	public void createNewUser(UserEntity jou) {
		userRepo.save(jou);
	}
	
	//getAll data
	public List<UserEntity> getAllEntries(){
		return userRepo.findAll();
	}
	
	//get by id
	public Optional<UserEntity> getById(ObjectId id) {
		return userRepo.findById(id);
	}
	
	//delete by id
	public void deleteById(ObjectId id) {
		userRepo.deleteById(id);
	}
	
	public UserEntity findByUserName(String name) {
		return userRepo.findByUserName(name);
	}
}
