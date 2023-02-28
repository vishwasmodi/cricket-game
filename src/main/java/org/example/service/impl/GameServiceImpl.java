package org.example.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.GameHelper;
import org.example.dto.GameReq;
import org.example.dto.MatchResult;
import org.example.dto.SeriesResult;
import org.example.model.Player;
import org.example.model.PlayerStats;
import org.example.model.Team;
import org.example.repository.MatchRepository;
import org.example.repository.PlayerRepository;
import org.example.repository.SeriesRepository;
import org.example.repository.TeamRepository;
import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private SeriesRepository seriesRepository;

    public static Integer numberOfOvers;

    private List<Team> setUpGame(GameReq gameReq) {
        numberOfOvers = gameReq.getNumberOfOvers();

        List<Team> teams = new ArrayList<>();
        for (String teamName : gameReq.getTeams()) {
            // Name should be unique and indexed
            Team team = teamRepository.findByName(teamName);
            teams.add(team);
        }
        return teams;
    }

    private void savePlayerStats(MatchResult matchResult) {
        for (PlayerStats playerStats : matchResult.getTeamStats1().values()) {

            Player player = playerRepository.findByPlayerId(playerStats.getPlayerId());
            if (player == null) {
                player.setTotalMatches(1);
                player.setTotalRuns(playerStats.getRunsScored());
                player.setTotalWickets(playerStats.getWicketsTaken());
            } else {
                player.setTotalMatches(player.getTotalMatches() + 1);
                player.setTotalRuns(player.getTotalRuns() + playerStats.getRunsScored());
                player.setTotalWickets(player.getTotalWickets() + playerStats.getWicketsTaken());
            }
            playerRepository.save(player);
        }

        for (PlayerStats playerStats : matchResult.getTeamStats2().values()) {
            Player player = playerRepository.findByPlayerId(playerStats.getPlayerId());
            if (player == null) {
                player.setTotalMatches(1);
                player.setTotalRuns(playerStats.getRunsScored());
                player.setTotalWickets(playerStats.getWicketsTaken());
            } else {
                player.setTotalMatches(player.getTotalMatches() + 1);
                player.setTotalRuns(player.getTotalRuns() + playerStats.getRunsScored());
                player.setTotalWickets(player.getTotalWickets() + playerStats.getWicketsTaken());
            }
            playerRepository.save(player);
        }
    }

    @Override
    public void addTeams(List<Team> teams) {
        for (Team team : teams) {
            teamRepository.save(team);
            for (Player player : team.getPlayers()) {
                playerRepository.save(player);
            }
        }
    }

    @Override
    public MatchResult playMatch(GameReq gameReq) {
        Match match = new Match();
        List<Team> teams = setUpGame(gameReq);

        // Change startPlaying to start
        MatchResult matchResult = match.startPlaying(teams.get(0), teams.get(1));

        savePlayerStats(matchResult);
        matchRepository.save(matchResult);
        return matchResult;
    }

    @Override
    public SeriesResult playSeries(GameReq gameReq) {
        Series series = new Series();
        List<Team> teams = setUpGame(gameReq);
        SeriesResult seriesResult = series.startPlaying(teams);
        for(MatchResult matchResult : seriesResult.getMatchResult()){
            savePlayerStats(matchResult);
        }
        seriesRepository.save(seriesResult);
        return seriesResult;
    }

    @Override
    public MatchResult getMatch(String matchId) {
        System.out.println("matchId " + matchId);
        return matchRepository.findByMatchId(matchId);
    }

    @Override
    public List<MatchResult> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public SeriesResult getSeries(String seriesId) {
        return seriesRepository.findBySeriesId(seriesId);
    }

    @Override
    public List<SeriesResult> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public MatchResult getMatchInSeries(String seriesId, String matchId) {
        return null;
    }

    @Override
    public Player getPlayerStats(String playerId) {
        Player overallPlayerStats = playerRepository.findByPlayerId(playerId);
        return overallPlayerStats;
    }

    @Override
    public PlayerStats getPlayerStatsInMatch(String matchId, String playerId) {
        MatchResult matchResult = matchRepository.findByMatchId(matchId);
        if (matchResult.getTeamStats1().containsKey(playerId)) {
            return matchResult.getTeamStats1().get(playerId);
        } else if (matchResult.getTeamStats2().containsKey(playerId)) {
            return matchResult.getTeamStats1().get(playerId);
        }
        return null;
    }
}
