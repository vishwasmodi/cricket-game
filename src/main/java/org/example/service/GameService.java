package org.example.service;

import org.example.dto.GameReq;
import org.example.dto.MatchResult;
import org.example.dto.SeriesResult;
import org.example.model.Player;
import org.example.model.PlayerStats;
import org.example.model.Team;

import java.util.List;


public interface GameService {

    void addTeams(List<Team> teams);
    MatchResult playMatch(GameReq gameReq);
    SeriesResult playSeries(GameReq gameReq);

    MatchResult getMatch(String matchId);

    List<MatchResult> getAllMatches();

    SeriesResult getSeries(String seriesId);

    List<SeriesResult> getAllSeries();

    MatchResult getMatchInSeries(String seriesId, String matchId);

    Player getPlayerStats(String playerId);

    PlayerStats getPlayerStatsInMatch(String matchId, String playerId);
}
