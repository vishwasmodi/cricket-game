package org.example.service.impl;

import org.example.GameHelper;
import org.example.dto.MatchResult;
import org.example.model.Player;
import org.example.model.PlayerStats;
import org.example.model.Team;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {

    final static Integer numberOfBallsInOver = 6;
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

    public MatchResult startPlaying(Team team1, Team team2) {

        Integer teamWhoWonToss = toss();
        System.out.println("Team " + teamWhoWonToss + " wins the toss and chooses to Bat");

        Integer team1Runs;
        Integer team2Runs;
        // Create a class instead of using Pair
        // Make POJO
        Pair<HashMap, Integer> innings1;
        Pair<HashMap, Integer> innings2;

        if (teamWhoWonToss == 1) {
            innings1 = playInnings(team1, team2);
            innings2 = playInnings(team2, team1);
            team1Runs = innings1.getSecond();
            team2Runs = innings2.getSecond();
        } else {
            innings1 = playInnings(team2, team1);
            innings2 = playInnings(team1, team2);
            team2Runs = innings1.getSecond();
            team1Runs = innings2.getSecond();
        }
        // Make list of team innings
        MatchResult matchResult = MatchResult.builder().teamStats1(innings1.getFirst()).teamStats2(innings2.getFirst())
                                             .team1Score(team1Runs).team2Score(team2Runs)
                                             .winnerTeam(team1Runs > team2Runs ? team1.getName() : team2.getName()).build();
        System.out.println("Team 1 scored " + team1Runs + " runs.");
        System.out.println("Team 2 scored " + team2Runs + " runs.");

        if (team1Runs > team2Runs) {
            System.out.println("Team 1 won by " + (team1Runs - team2Runs) + " runs.");
        } else if (team1Runs < team2Runs) {
            System.out.println("Team 2 won by " + (team2Runs - team1Runs) + " runs.");
        } else {
            System.out.println("It's a draw");
        }

        return matchResult;
    }

    private Pair<HashMap, Integer> playInnings(Team battingTeam, Team ballingTeam) {

        ArrayList<Player> battingPlayers = sortByBattingSkill(battingTeam.getPlayers());
        ArrayList<Player> ballingPlayers = sortByBallingSkill(ballingTeam.getPlayers());

        Integer battingIndex = 0, ballingIndex = 0, totalRuns = 0, currentPlayerRuns = 0;

        // Store playerStats wrt to playerId
        // Never store in map
        HashMap<String, PlayerStats> playersStats = new HashMap<>();
        Integer numberOfOvers = GameServiceImpl.numberOfOvers;

        for (int over = 1; over <= numberOfOvers; over++) {
            for (int ball = 1; ball <= numberOfBallsInOver; ball++) {

                Player currentBatsmen = battingPlayers.get(battingIndex);
                Player currentBowler = ballingPlayers.get(ballingIndex);

                Integer res = helper.randomResultGenerator();
                System.out.print("Over: " + over + " | Ball: " + ball + " | Batsmen: " + currentBatsmen.getName() +
                                 " | Verdict: ");

                if (res == 7) {
                    playersStats.put(currentBatsmen.getPlayerId(),
                            new PlayerStats(currentBatsmen.getPlayerId(), currentBatsmen.getName(), currentPlayerRuns, 0));


                    currentPlayerRuns = 0;
                    System.out.println("Out");
                    battingIndex++;
                } else {
                    totalRuns += res;
                    currentPlayerRuns += res;
                    System.out.println(res + " runs!");
                }

                if (battingIndex == 10) {
                    break;
                }
            }
            if (battingIndex == 10) {
                break;
            }
        }
        System.out.println("Innings over");
        System.out.println("Total runs of team " + battingTeam.getName() + " are " + totalRuns);
        return Pair.of(playersStats, totalRuns);
    }
}