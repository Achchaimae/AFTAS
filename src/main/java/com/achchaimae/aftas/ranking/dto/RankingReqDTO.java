    package com.achchaimae.aftas.ranking.dto;

    import jakarta.validation.constraints.*;
    import lombok.Data;

    @Data
    public class RankingReqDTO {
        @NotNull(message = "Ranking ID is required")
        private RankingIDReq id;

        @Min(value = 1, message = "Rank must be a positive number")
        private int rank;

        @Min(value = 0, message = "Score must be a non-negative number")
        private int score;
    }
