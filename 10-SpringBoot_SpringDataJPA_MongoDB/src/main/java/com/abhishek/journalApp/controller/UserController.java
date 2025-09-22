package com.abhishek.journalApp.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.journalApp.entity.UserEntity;
import com.abhishek.journalApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public void createUser(@RequestBody UserEntity user) {
		userService.createUser(user);
	}

	@GetMapping
	public List<UserEntity> getAllUser() {
		return userService.getAllEntries();

	}

	@GetMapping("id/{myId}")
	public ResponseEntity<UserEntity> findById(@PathVariable ObjectId myId) {
		Optional<UserEntity> byId = userService.getById(myId);
		if (byId.isPresent()) {
			return new ResponseEntity<>(byId.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/{userName}")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user, @PathVariable String userName) {

		UserEntity byUserName = userService.findByUserName(userName);
		if (byUserName != null) {
			byUserName.setUserName(user.getUserName());
			byUserName.setPassword(user.getPassword());

			userService.createUser(byUserName);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
