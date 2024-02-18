package com.achchaimae.aftas;

import com.achchaimae.aftas.ranking.Ranking;

import com.achchaimae.aftas.ranking.RankingRepository;
import com.achchaimae.aftas.ranking.RankingService;
import com.achchaimae.aftas.ranking.dto.RankingRespDTO;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RankingServiceTest {

    @Autowired
    private RankingService rankingService;

    @MockBean
    private RankingRepository rankingRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void testCalculateAndFetchRankings() {
        // Mock the necessary objects
        String competitionCode = "COMP_CODE";
        List<Ranking> rankings = new ArrayList<>();
        rankings.add(new Ranking());

        // Set up the mock behavior
        Mockito.when(rankingRepository.calculateRankingsForCompetition(competitionCode)).thenReturn(rankings);
        Mockito.when(rankingRepository.save(Mockito.any(Ranking.class))).thenReturn(new Ranking());
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.eq(RankingRespDTO.class))).thenReturn(new RankingRespDTO());

        // Call the method under test
        List<RankingRespDTO> result = rankingService.calculateAndFetchRankings(competitionCode);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testCalculateAndFetchRankings_NoRankingsFound() {
        // Mock the necessary objects
        String competitionCode = "COMP_CODE";
        List<Ranking> rankings = new ArrayList<>();

        // Set up the mock behavior
        Mockito.when(rankingRepository.calculateRankingsForCompetition(competitionCode)).thenReturn(rankings);

        // Call the method under test
        List<RankingRespDTO> result = rankingService.calculateAndFetchRankings(competitionCode);

        assertNotNull(result);
        assertEquals(0, result.size());

    }

    @Test
    public void testCalculateAndFetchRankings_MultipleRankings() {
        String competitionCode = "COMP_CODE";
        List<Ranking> rankings = new ArrayList<>();
        rankings.add(new Ranking());
        rankings.add(new Ranking());
        rankings.add(new Ranking());

        // Set up the mock behavior
        Mockito.when(rankingRepository.calculateRankingsForCompetition(competitionCode)).thenReturn(rankings);
        Mockito.when(rankingRepository.save(Mockito.any(Ranking.class))).thenReturn(new Ranking());
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.eq(RankingRespDTO.class))).thenReturn(new RankingRespDTO());

        // Call the method under test
        List<RankingRespDTO> result = rankingService.calculateAndFetchRankings(competitionCode);

        assertNotNull(result);
        assertEquals(3, result.size());
    }

}
