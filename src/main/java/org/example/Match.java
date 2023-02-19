package org.example;

import org.example.dto.Player;
import org.example.dto.PlayerStats;
import org.example.dto.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {

    final static Integer numberOfBallsInOver = 6;
    static Integer numberOfOvers = CricketGame.numberOfOvers;
    private GameHelper helper = new GameHelper();

    public static ArrayList<Player> sortByBattingSkill(ArrayList<Player> list) {
        list.sort((o1, o2) -> o2.getBattingSkill().compareTo(o1.getBattingSkill()));
        return list;
    }

    public static ArrayList<Player> sortByBallingSkill(ArrayList<Player> list) {
        list.sort((o1, o2) -> o2.getBallingSkill().compareTo(o1.getBallingSkill()));
        return list;
    }

    public Integer toss() {
        return helper.randomTossGenerator();
    }

    public void startPlaying(Team team1, Team team2) {

        Integer teamWhoWonToss = toss();
        System.out.println("Team " + teamWhoWonToss + " wins the toss and chooses to Bat");

        Integer team1Runs;
        Integer team2Runs;

        if (teamWhoWonToss == 1) {
            team1Runs = playInnings(team1, team2);
            team2Runs = playInnings(team2, team1);
        } else {
            team2Runs = playInnings(team2, team1);
            team1Runs = playInnings(team1, team2);
        }

        System.out.println("Team 1 scored " + team1Runs + " runs.");
        System.out.println("Team 2 scored " + team2Runs + " runs.");

        if (team1Runs > team2Runs) {
            System.out.println("Team 1 won by " + (team1Runs - team2Runs) + " runs.");
        } else if (team1Runs < team2Runs) {
            System.out.println("Team 2 won by " + (team2Runs - team1Runs) + " runs.");
        } else {
            System.out.println("It's a draw");
        }
    }

    private Integer playInnings(Team battingTeam, Team ballingTeam) {

        ArrayList<Player> battingPlayers = sortByBattingSkill(battingTeam.getPlayers());
        ArrayList<Player> ballingPlayers = sortByBallingSkill(ballingTeam.getPlayers());

        Integer battingPlayer = 0, ballingPlayer = 0, totalRuns = 0;
        HashMap<Integer, PlayerStats> playersStats = new HashMap<>();
        for (int over = 1; over <= numberOfOvers; over++) {
            for (int ball = 1; ball <= numberOfBallsInOver; ball++) {

                Integer res = helper.randomResultGenerator();
                System.out.print("Over: " + over + " | Ball: " + ball + " | Batsmen: " +
                                 battingPlayers.get(battingPlayer).getName() + " | Verdict: ");

                if (res == 7) {
                    playersStats.put(battingPlayers.get(battingPlayer).getId(), new PlayerStats(0, "vishwas", 0, 0));
                    System.out.println("Out");
                    battingPlayer++;
                } else {
                    totalRuns += res;
                    System.out.println(res + " runs!");
                }

                if (battingPlayer == 10) {
                    break;
                }
            }
            if (battingPlayer == 10) {
                break;
            }
        }
        System.out.println("Innings over");
        System.out.println("Total runs of team " + battingTeam.getName() + " are " + totalRuns);
        return totalRuns;
    }
}