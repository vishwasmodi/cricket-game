package org.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "team")
public class Team {
    Team(){
        this.players = new ArrayList<>();
    }
    @Id
    private String teamId;
    private String name;
    private ArrayList<Player> players;
    public void addPlayer(Player player) {
        this.players.add(player);
    }
}