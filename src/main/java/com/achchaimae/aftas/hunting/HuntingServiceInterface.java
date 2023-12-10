package com.achchaimae.aftas.hunting;


import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;

import java.util.List;

public interface HuntingServiceInterface {

    List<HuntingRespDTO> getHuntings();
    HuntingRespDTO saveHunting(HuntingReqDTO hunting);
    HuntingRespDTO updateHunting(HuntingReqDTO hunting, Integer id);
    Integer DeleteHunting(Integer huntingId);
    HuntingRespDTO findHunting(Integer huntingId);

}
