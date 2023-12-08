package com.achchaimae.aftas.Fish.DTO;

import com.achchaimae.aftas.Level.DTO.LevelReqDTO;
import lombok.Data;

@Data
public class FishRespDTO {
    private String name;
    private  Float averageWeight;
    private LevelReqDTO level;
    private LevelReqDTO hunting;
}
