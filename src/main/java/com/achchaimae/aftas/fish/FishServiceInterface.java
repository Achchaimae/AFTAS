package com.achchaimae.aftas.fish;

import com.achchaimae.aftas.fish.dto.FishReqDTO;
import com.achchaimae.aftas.fish.dto.FishRespDTO;

import java.util.List;

public interface FishServiceInterface {

    List<FishRespDTO> getFishes();
    FishRespDTO saveFish(FishReqDTO fish);
    FishRespDTO updateFish(FishReqDTO fish, String name);
    Integer DeleteFish(String fishName);
    FishRespDTO findFish(String fishName);
}
