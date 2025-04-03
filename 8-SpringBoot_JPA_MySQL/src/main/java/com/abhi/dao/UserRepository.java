package com.abhi.dao;

import org.springframework.data.repository.CrudRepository;

import com.abhi.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
