package org.example.repository;

import org.example.dto.MatchRes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchRes, Long> {

}
