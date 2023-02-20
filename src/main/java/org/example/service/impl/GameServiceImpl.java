package org.example.service.impl;

import org.example.GameHelper;
import org.example.dto.MatchReq;
import org.example.dto.MatchRes;
import org.example.dto.SeriesReq;
import org.example.dto.SeriesRes;
import org.example.model.Team;
import org.example.repository.MatchRepository;
import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private MatchRepository matchRepository;

    private static GameHelper helper = new GameHelper();
    public static Integer numberOfOvers;
    Team team1;
    Team team2;

    private void setUpGame(MatchReq matchReq) {
        numberOfOvers = matchReq.getNumberOfOvers();

        team1 = new Team();
        team2 = new Team();

        CreateTeam.createTeam(team1);
        CreateTeam.createTeam(team2);
    }

    @Override
    public MatchRes playMatch(MatchReq matchReq) {
        Match match = new Match();
        setUpGame(matchReq);
        MatchRes matchRes = match.startPlaying(team1, team2);
        matchRepository.save(matchRes);
        return matchRes;
    }

    @Override
    public SeriesRes playSeries(SeriesReq seriesReq) {
        Series series = new Series();
//        SeriesRes seriesRes = series.startPlaying(seriesReq);
        return null;
    }
}
