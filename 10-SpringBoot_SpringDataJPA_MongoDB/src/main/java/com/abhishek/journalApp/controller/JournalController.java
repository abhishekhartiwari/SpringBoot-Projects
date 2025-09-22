package com.abhishek.journalApp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.journalApp.entity.JournalEntity;
import com.abhishek.journalApp.entity.UserEntity;
import com.abhishek.journalApp.service.JournalEntryService;
import com.abhishek.journalApp.service.UserService;

@RestController
@RequestMapping("/journal")
public class JournalController {

	@Autowired
	private JournalEntryService service;
	
	@Autowired
	private UserService userService;

	

	@GetMapping("{userName}")
	public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable  String userName) {
		UserEntity user = userService.findByUserName(userName);
		List<JournalEntity> all = user.getJournalEntries();
		if(!all.equals(null) && !all.isEmpty()) {
			return new ResponseEntity<>(all, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("{userName}")
	public  ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity journal, @PathVariable String userName) {
		try {
			service.createJournal(journal, userName);
			return new ResponseEntity<>(journal, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("id/{myId}")
	public ResponseEntity<JournalEntity> findById(@PathVariable ObjectId myId) {

		Optional<JournalEntity> byId = service.getById(myId);
		if(byId.isPresent()) {
			
			return new ResponseEntity<>(byId.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("id/{userName}/{myId}")
	public ResponseEntity<?> deleteById(@PathVariable ObjectId myId, @PathVariable String userName) {
		service.deleteById(myId, userName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("id/{userName}/{myId}")
	public ResponseEntity<?> update(@PathVariable ObjectId myId, @RequestBody JournalEntity newEntry, @PathVariable String userName) {

		JournalEntity oldEntry = service.getById(myId).orElse(null);
		if (oldEntry != null) {
			oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle():oldEntry.getTitle());
			oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent():oldEntry.getContent());
			service.createJournal(oldEntry);
			return new ResponseEntity<>(oldEntry, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

	}
}
