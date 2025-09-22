package com.abhishek.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhishek.journalApp.entity.JournalEntity;


public interface JournalEntryRepository extends MongoRepository<JournalEntity, ObjectId> {

}
