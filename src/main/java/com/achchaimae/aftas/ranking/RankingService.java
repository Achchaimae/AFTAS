package com.achchaimae.aftas.ranking;


import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.competition.CompetitionRepository;
import com.achchaimae.aftas.hunting.Hunting;
import com.achchaimae.aftas.hunting.HuntingRepository;
import com.achchaimae.aftas.member.Member;
import com.achchaimae.aftas.member.MemberRepository;
import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RankingService implements RankingServiceInterface{

    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final HuntingRepository huntingRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public RankingService(RankingRepository rankingRepository, CompetitionRepository competitionRepository, HuntingRepository huntingRepository, MemberRepository memberRepository) {
        this.rankingRepository = rankingRepository;
        this.competitionRepository = competitionRepository;
        this.huntingRepository = huntingRepository;
        this.memberRepository = memberRepository;
    }
    RankingID rankingId = new RankingID();
    @Autowired
    ModelMapper modelMapper;
    Optional<Member> member;
    Optional<Competition> competition;
    public List<RankingRespDTO> getRankings(){
        return rankingRepository.findAll().stream().map(ranking -> modelMapper.map(ranking, RankingRespDTO.class)).collect(Collectors.toList());
    }


    public RankingRespDTO saveRanking(RankingReqDTO rankingReqDTO) {
        Ranking rankingE = modelMapper.map(rankingReqDTO, Ranking.class);
        member = memberRepository.findById(rankingReqDTO.getId().getMember_id());
        competition = competitionRepository.findById(rankingReqDTO.getId().getCompetition_id());

        if (member.isPresent() && competition.isPresent()) {

            long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(),competition.get().getDate());

            if (daysDifference > 1) {
                rankingId.setCompetition(competition.get());
                rankingId.setMember(member.get());
                rankingE.setId(rankingId);
                rankingE = rankingRepository.save(rankingE);
                return modelMapper.map(rankingE, RankingRespDTO.class);
            }

        }

        return null;
    }


    public List<RankingRespDTO> calculateAndFetchRankings(String competitionCode) {
        List<Ranking> rankings = rankingRepository.calculateRankingsForCompetition(competitionCode);
        return IntStream.range(0,rankings.size()).mapToObj(i -> {
            rankings.get(i).setRank(i+1);
            return modelMapper.map(rankingRepository.save(rankings.get(i)),RankingRespDTO.class);
        }).collect(Collectors.toList());
    }

//    public RankingRespDTO updateRanking(RankingReqDTO ranking, Integer id) {
//        Optional<Ranking> rankingOptional = rankingRepository.findById(id);
//        if(rankingOptional.isPresent()){
//            ranking.setId(rankingOptional.get().getId());
//            return modelMapper.map(rankingRepository.save(modelMapper.map(ranking , Ranking.class)), RankingRespDTO.class);
//        }
//        return null;
//    }
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
    public List<RankingRespDTO> findByComp(String searchTerm) {
        List<Ranking> rankings = rankingRepository.findById_Competition_codeOrderByRankAsc(searchTerm);

        if (rankings != null && !rankings.isEmpty()) {
            // Use Java streams to map each Ranking to RankingRespDTO
            return rankings.stream()
                    .map(ranking -> modelMapper.map(ranking, RankingRespDTO.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
