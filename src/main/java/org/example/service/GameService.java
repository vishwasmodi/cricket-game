package org.example.service;

import org.example.dto.MatchReq;
import org.example.dto.MatchRes;
import org.example.dto.SeriesReq;
import org.example.dto.SeriesRes;

public interface GameService {
    MatchRes playMatch(MatchReq matchReq);
    SeriesRes playSeries(SeriesReq seriesReq);
}
