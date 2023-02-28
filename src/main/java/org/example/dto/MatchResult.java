package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.example.model.PlayerStats;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@Document(collection = "match")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResult implements Serializable {
    @Id
    private String matchId;
    private HashMap<String, PlayerStats> teamStats1;
    private HashMap<String, PlayerStats> teamStats2;
    private String winnerTeam;
    private String loserTeam;
    private Integer team1Score;
    private Integer team2Score;
}
