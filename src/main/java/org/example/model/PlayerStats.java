package org.example.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStats {
    private String playerId;
    private String name;
    private Integer runsScored;
    private Integer wicketsTaken;
}
