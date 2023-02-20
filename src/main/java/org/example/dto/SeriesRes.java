package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.example.service.impl.Match;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "game")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeriesRes {
    List<MatchRes> matchesResult;
    String winnerTeam;
}
