    package com.achchaimae.aftas.ranking;

    import com.achchaimae.aftas.competition.Competition;
    import com.achchaimae.aftas.member.Member;
    import jakarta.persistence.*;
    import lombok.Data;



    @Data
    @Entity
    public class Ranking {
        @EmbeddedId
        private RankingID id;
        private int rank;
        private Long score;
        public Ranking(Member member, Competition competition, Long score) {
            this.id = new RankingID(competition,member);
            this.score = score;
        }
        public Ranking(Member member, Competition competition, Long score,Integer rank) {
            this.id = new RankingID(competition,member);
            this.score = score;
            this.rank = rank;
        }
        public Ranking() {
        }
    }
