package com.abhishek.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhishek.journalApp.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {
	
	UserEntity findByUserName(String name);

}
