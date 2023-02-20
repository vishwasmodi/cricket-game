package org.example.service.impl;


import org.example.GameHelper;
import org.example.model.Player;
import org.example.model.Team;

public class CreateTeam {

    private static GameHelper helper = new GameHelper();
    private static Integer teamNumber = 1;

    static void createTeam(Team team) {
        team.setName(helper.getUserInput("Enter Team's name ="));

        for (int player = 1; player <= 11; player++) {

            Integer playerId = (teamNumber - 1) * 9 + player;
            String playerName = String.valueOf((char) ((int) 'A' + ((teamNumber - 1) * 9 + player - 1)));
            Integer battingSkill = helper.randomSkillGenerator();
            Integer ballingSkill = helper.randomSkillGenerator();

            Player p = new Player();
            p.setId(playerId);
            p.setName(playerName);
            p.setBattingSkill(battingSkill);
            p.setBallingSkill(ballingSkill);

            team.addPlayer(p);
        }
        teamNumber++;
    }
}
