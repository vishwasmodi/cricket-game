package org.example.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
public class TeamStats {
    private String teamId;
    private String name;
    private Integer points;
    private List<PlayerStats> playerStats;
}
