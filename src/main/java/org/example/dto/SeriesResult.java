package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.example.model.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "series")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class SeriesResult {
    @Id
    private String seriesId;
    private List<Team> teams;
    private List<MatchResult> matchResult;
    private Team winnerTeam;
}
