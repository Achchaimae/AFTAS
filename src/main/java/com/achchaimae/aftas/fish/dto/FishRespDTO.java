package com.achchaimae.aftas.fish.dto;

import com.achchaimae.aftas.level.dto.LevelReqDTO;
import lombok.Data;

@Data
public class FishRespDTO {
    private String name;
    private  Float averageWeight;
    private LevelReqDTO level;
    private LevelReqDTO hunting;
}
