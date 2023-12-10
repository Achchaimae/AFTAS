package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;
import com.achchaimae.aftas.hunting.Hunting;
import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RankingService implements RankingServiceInterface{

    private final RankingRepository rankingRepository;

    @Autowired
    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    public List<RankingRespDTO> getRankings(){
        return rankingRepository.findAll().stream().map(ranking -> modelMapper.map(ranking, RankingRespDTO.class)).collect(Collectors.toList());
    }

    public RankingRespDTO saveRanking(RankingReqDTO ranking) {
        return modelMapper.map(rankingRepository.save(modelMapper.map(ranking, Ranking.class)),RankingRespDTO.class);
    }

    public RankingRespDTO updateRanking(RankingReqDTO ranking, Integer id) {
        Optional<Ranking> rankingOptional = rankingRepository.findById(id);
        if(rankingOptional.isPresent()){
            ranking.setId(rankingOptional.get().getId());
            return modelMapper.map(rankingRepository.save(modelMapper.map(ranking , Ranking.class)), RankingRespDTO.class);
        }
        return null;
    }

    public Integer DeleteHunting(Integer rankingId){
        Optional<Ranking> exist = rankingRepository.findById(rankingId);

        if(exist.isPresent()){
            rankingRepository.deleteById(rankingId);
            return 1;
        }
        return 0;
    }

    public RankingRespDTO findRanking(Integer rankingId) {
        Optional<Ranking> rankingOptional = rankingRepository.findById(rankingId);
        if (rankingOptional.isPresent()) {
            Ranking ranking = rankingOptional.get();
            return modelMapper.map(ranking, RankingRespDTO.class);
        }
        return null;
    }

}
