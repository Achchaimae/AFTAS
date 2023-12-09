package com.achchaimae.aftas.fish.DTO;

import com.achchaimae.aftas.level.DTO.LevelReqDTO;
import lombok.Data;

@Data
public class FishRespDTO {
    private String name;
    private  Float averageWeight;
    private LevelReqDTO level;
    private LevelReqDTO hunting;
}
