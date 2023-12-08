package com.achchaimae.aftas.Level.DTO;

import com.achchaimae.aftas.Fish.DTO.FishReqDTO;
import lombok.Data;

@Data
public class LevelRespDTO {
    private int code;
    private String description;
    private Integer points;
    private FishReqDTO fishes;
}
