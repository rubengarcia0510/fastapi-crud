package com.example.backendreactive.repository;

import com.example.backendreactive.model.Groups;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupsRepository extends MongoRepository<Groups, String> {
}
