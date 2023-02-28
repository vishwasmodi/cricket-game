package org.example.controller;

import org.example.dto.GameReq;
import org.example.dto.MatchResult;
import org.example.dto.SeriesResult;
import org.example.model.Player;
import org.example.model.PlayerStats;
import org.example.model.Team;
import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/game", produces = "application/json")
public class GameController {
    @Autowired
    private GameService gameService;


    // Make documentation

    // Change playerId to id for DB
    // Directly use _id from mongodb
    // Add teamId into player table and remove team and make index on teamId

    // rename /addTeams to /teams
    @PostMapping("/addTeams")
    public void addTeams(@RequestBody List<Team> teams) {
        gameService.addTeams(teams);
    }

    @PostMapping("/match")
    public ResponseEntity<MatchResult> playGame(@RequestBody GameReq gameReq) {
        MatchResult matchResult = gameService.playMatch(gameReq);
        System.out.println("match res" + matchResult);
        return new ResponseEntity<>(matchResult, HttpStatus.OK);
    }
    @PostMapping("/series")
    public ResponseEntity<SeriesResult> playSeries(@RequestBody GameReq gameReq) {
        SeriesResult seriesResult = gameService.playSeries(gameReq);
        return new ResponseEntity<>(seriesResult, HttpStatus.OK);
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity<MatchResult> getMatch(@PathVariable String matchId) {
        return new ResponseEntity<>(gameService.getMatch(matchId), HttpStatus.OK);
    }
    @GetMapping("/match")
    public ResponseEntity<List<MatchResult>> getAllMatches() {
        return new ResponseEntity<>(gameService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/series/{seriesId}")
    public ResponseEntity<SeriesResult> getSeries(@PathVariable String seriesId) {
        return new ResponseEntity<>(gameService.getSeries(seriesId), HttpStatus.OK);
    }

    @GetMapping("/series")
    public ResponseEntity<List<SeriesResult>> getAllSeries() {
        return new ResponseEntity<>(gameService.getAllSeries(), HttpStatus.OK);
    }

    // Path variable and query params
    @GetMapping("/series/{seriesId}/match/{matchId}")
    public ResponseEntity<MatchResult> getMatchInSeries(@PathVariable String seriesId, @PathVariable String matchId) {
        return new ResponseEntity<>(gameService.getMatchInSeries(seriesId, matchId), HttpStatus.OK);
    }

    @GetMapping("/player-stats/{playerId}")
    public ResponseEntity<Player> getPlayerStats(@PathVariable String playerId) {
        return new ResponseEntity<>(gameService.getPlayerStats(playerId), HttpStatus.OK);
    }

    // rename /player-stats to /player/stats
    @GetMapping("/player-stats/{matchId}/{playerId}")
    public ResponseEntity<PlayerStats> getPlayerStatsInMatch(@PathVariable String matchId, @PathVariable String playerId) {
        return new ResponseEntity<>(gameService.getPlayerStatsInMatch(matchId, playerId), HttpStatus.OK);
    }
}
