package org.example.service.impl;

import org.example.dto.MatchResult;
import org.example.dto.SeriesResult;
import org.example.model.Team;
import org.example.model.TeamStats;

import java.util.ArrayList;
import java.util.List;

public class Series {
    public SeriesResult startPlaying(List<Team> teams) {

        ArrayList<TeamStats> teamStats = new ArrayList<>();
        ArrayList<MatchResult> matchResults = new ArrayList<>();
        for(Team team : teams) {
            teamStats.add(new TeamStats(team.getTeamId(), team.getName(), 0, new ArrayList<>()));
        }
        for(int i=0; i<teams.size(); i++) {
            for(int j=i+1; j<teams.size(); j++) {
                MatchResult matchResult = new Match().startPlaying(teams.get(i), teams.get(j));
                matchResults.add(matchResult);
                teamStats.stream().filter(teamStat -> teamStat.getName().equals(matchResult.getWinnerTeam())).findFirst().ifPresent(teamStat -> teamStat.setPoints(teamStat.getPoints() + 2));
            }
        }
        Team winnerTeam = teams.stream().filter(team -> team.getTeamId().equals(teamStats.stream().max((teamStat1, teamStat2) -> teamStat1.getPoints() - teamStat2.getPoints()).get().getTeamId())).findFirst().get();
        SeriesResult seriesResult =
                SeriesResult.builder().teams(teams).matchResult(matchResults).winnerTeam(winnerTeam).build();
        return seriesResult;
    }
}