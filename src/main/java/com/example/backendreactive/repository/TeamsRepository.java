package com.example.backendreactive.repository;

import com.example.backendreactive.model.Teams;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamsRepository extends MongoRepository<Teams, String> {
}
