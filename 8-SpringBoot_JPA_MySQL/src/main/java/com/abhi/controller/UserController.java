package com.abhi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.entity.User;
import com.abhi.service.UserService;


//C-Create R-Read U-Update D-Delete Operation


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Just for testing on POSTMAN
	@RequestMapping("/hello")
	public String getMessage() {
		System.out.println("ur first request");
		return  "ur first requesyt";
	}
	
	//to get all the user in table/ Means all row
	@RequestMapping(method = RequestMethod.GET ,value = "/user")
	public List<User> getAllUser() {
		return userService.getServiceAllUsers();
	}
	
	//to get a particular user by id
	@RequestMapping(method = RequestMethod.GET ,value = "/user/{userId}")
	public Optional<User> getUser(@PathVariable int userId) {
		return userService.getServiceUser(userId);
	}

	//to add a new user into the database table(user)
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public String addUser(@RequestBody User user) {
		userService.addServiceUser(user);
		return "Used has been added";
	}
	
	//to update a particular user by id
	@RequestMapping(method = RequestMethod.PUT ,value = "/user/{userId}")
	public String updateUser(@PathVariable Integer userId, @RequestBody User user) {
		userService.updateServiceUser(userId, user);
		return "user "+userId+" updated";
	}
	
	//to delete a particular user by id
	@RequestMapping(method = RequestMethod.DELETE ,value = "/user/{userId}")
	public String deleteUser(@PathVariable int userId) {
		userService.deleteServiceUser(userId);
		return "user "+userId+" deleted";
	}

}
