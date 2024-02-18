package com.achchaimae.aftas.level.dto;

import com.achchaimae.aftas.fish.dto.FishReqDTO;
import lombok.Data;

@Data
public class LevelRespDTO {
    private int code;
    private String description;
    private Integer points;
    private FishReqDTO fishes;
}
