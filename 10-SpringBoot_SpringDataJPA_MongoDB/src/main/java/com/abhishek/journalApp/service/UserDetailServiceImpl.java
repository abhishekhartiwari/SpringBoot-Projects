package com.abhishek.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.abhishek.journalApp.entity.UserEntity;
import com.abhishek.journalApp.repository.UserRepository;


@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUserName(username);
		
		if(user != null) {
			
			UserDetails userDetails = User.builder()
			.username(user.getUserName())
			.password(user.getPassword())
			.roles(user.getRoles().toArray(new String[0]))
			.build();
			
			return userDetails;
		}
		throw new UsernameNotFoundException("User "+ username+ "found");
	}

}
