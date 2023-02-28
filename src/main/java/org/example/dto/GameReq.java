package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
public class GameReq {
    @NotNull
    private Integer numberOfOvers;
    @NotNull
    private ArrayList<String> teams;
    public Integer numberOfTeams(){
        return teams.size();
    }
}
