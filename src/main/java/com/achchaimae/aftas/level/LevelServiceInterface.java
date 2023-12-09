package com.achchaimae.aftas.level;

import com.achchaimae.aftas.level.DTO.LevelReqDTO;
import com.achchaimae.aftas.level.DTO.LevelRespDTO;

import java.util.List;

public interface LevelServiceInterface {
    List<LevelRespDTO> getLevels();
    LevelRespDTO saveLevel(LevelReqDTO level);
    LevelRespDTO updateLevel(LevelReqDTO level, Integer id);
    Integer DeleteLevel(Integer levelId);
    LevelRespDTO findLevel(Integer levelId);
}
