package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.example.model.PlayerStats;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@Document(collection = "match")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchRes {
    HashMap<Integer, PlayerStats> teamStats1;
    HashMap<Integer, PlayerStats> teamStats2;
    String winnerTeam;
    String loserTeam;
    Integer team1Score;
    Integer team2Score;
}
