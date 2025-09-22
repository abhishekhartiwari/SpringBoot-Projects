package com.abhishek.journalApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.journalApp.entity.JournalEntity;
import com.abhishek.journalApp.entity.UserEntity;
import com.abhishek.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository repo;
	
	@Autowired
	private UserService userService;

	//create document in collection in mongo DB
	
	@Transactional
	public void createJournal(JournalEntity jou, String userName) {
		UserEntity user = userService.findByUserName(userName);
		jou.setDate(LocalDateTime.now());
		JournalEntity save = repo.save(jou);
		user.getJournalEntries().add(save);
		userService.createUser(user);
	}
	
	public void createJournal(JournalEntity jou) {
		repo.save(jou);
	}
	
	//getAll data
	public List<JournalEntity> getAllEntries(){
		return repo.findAll();
	}
	
	//get by id
	public Optional<JournalEntity> getById(ObjectId id) {
		return repo.findById(id);
	}
	
	//delete by id
	public void deleteById(ObjectId id, String userName) {
		UserEntity user = userService.findByUserName(userName);
		user.getJournalEntries().removeIf(x -> x.getId().equals(id));
		userService.createUser(user);
		repo.deleteById(id);
	}
}
