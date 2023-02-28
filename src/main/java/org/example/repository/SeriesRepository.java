package org.example.repository;

import org.example.dto.SeriesResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<SeriesResult, String> {
    SeriesResult findBySeriesId(String seriesId);
}
