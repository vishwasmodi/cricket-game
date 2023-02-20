package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.MatchReq;
import org.example.dto.MatchRes;
import org.example.dto.SeriesReq;
import org.example.dto.SeriesRes;
import org.example.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private GameService gameService;

    @PostMapping("/match")
    public MatchRes playGame(@RequestBody MatchReq matchReq) {
        return gameService.playMatch(matchReq);
    }
    @PostMapping("/series")
    public SeriesRes playSeries(@RequestBody SeriesReq seriesReq) {
        return gameService.playSeries(seriesReq);
    }
}
