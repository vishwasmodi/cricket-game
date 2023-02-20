package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.example.model.Team;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Builder
@Document(collection = "game")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchReq {
    Team team1;
    Team team2;
    Integer numberOfOvers;
}
