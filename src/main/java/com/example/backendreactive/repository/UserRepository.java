package com.example.backendreactive.repository;

import com.example.backendreactive.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {
}
