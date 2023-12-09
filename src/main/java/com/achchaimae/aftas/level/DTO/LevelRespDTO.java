package com.achchaimae.aftas.level.DTO;

import com.achchaimae.aftas.fish.DTO.FishReqDTO;
import lombok.Data;

@Data
public class LevelRespDTO {
    private int code;
    private String description;
    private Integer points;
    private FishReqDTO fishes;
}
