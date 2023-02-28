package org.example.repository;

import org.example.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {
    Team findByName(String name);
}
