package com.achchaimae.aftas.ranking;


import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.competition.CompetitionRepository;
import com.achchaimae.aftas.fish.Fish;
import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;
import com.achchaimae.aftas.member.Member;
import com.achchaimae.aftas.member.MemberRepository;
import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RankingService implements RankingServiceInterface{

    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public RankingService(RankingRepository rankingRepository, CompetitionRepository competitionRepository, MemberRepository memberRepository) {
        this.rankingRepository = rankingRepository;
        this.competitionRepository = competitionRepository;
        this.memberRepository = memberRepository;
    }

    @Autowired
    ModelMapper modelMapper;
    Optional<Member> member;
    Optional<Competition> competition;
    public List<RankingRespDTO> getRankings(){
        return rankingRepository.findAll().stream().map(ranking -> modelMapper.map(ranking, RankingRespDTO.class)).collect(Collectors.toList());
    }

//    public RankingRespDTO saveRanking(RankingReqDTO ranking) {
//        Ranking ranking1 = modelMapper.map(ranking , Ranking.class);
//
//        competition = competitionRepository.findById(ranking.getId().getCompetition().getCode());
//        member = memberRepository.findById(ranking.getId().getMember().getNum());
//
//        if(competition.isPresent() && member.isPresent() ){
//            ranking.set
//        }
//
//        return modelMapper.map(rankingRepository.save(modelMapper.map(ranking, Ranking.class)),RankingRespDTO.class);
//
//
//    }

    public RankingRespDTO saveRanking(RankingReqDTO ranking) {
        Ranking ranking1 = modelMapper.map(ranking, Ranking.class);

        Optional<Competition> competition = competitionRepository.findById(ranking.getId().getCompetition().getCode());
        Optional<Member> member = memberRepository.findById(ranking.getId().getMember().getNum());

        if (competition.isPresent() && member.isPresent()) {
            ranking1.setId(new RankingID(competition.get(), member.get()));
            Ranking savedRanking = rankingRepository.save(ranking1);
            return modelMapper.map(savedRanking, RankingRespDTO.class);
        } else {
            // Handle case when either competition or member is not found
            // Return an appropriate response or throw an exception
            return null;
        }

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
