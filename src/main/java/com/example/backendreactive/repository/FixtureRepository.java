package com.example.backendreactive.repository;

import com.example.backendreactive.model.Fixture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FixtureRepository extends MongoRepository<Fixture, String> {
}
