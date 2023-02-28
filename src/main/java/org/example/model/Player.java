package org.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Player {
    Player(){
        this.totalMatches = 0;
        this.totalRuns = 0;
        this.totalWickets = 0;
    }
    @Indexed(unique = true)
    @Id
    private String playerId;
    private String name;
    private Integer battingSkill;
    private Integer ballingSkill;
    private Integer totalMatches;
    private Integer totalRuns;
    private Integer totalWickets;
}