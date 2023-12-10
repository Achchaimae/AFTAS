package com.achchaimae.aftas.hunting;
import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HuntingService implements HuntingServiceInterface {
    private final HuntingRepository huntingRepository;

    @Autowired
    public HuntingService(HuntingRepository huntingRepository) {
        this.huntingRepository = huntingRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    public List<HuntingRespDTO> getHuntings(){
        return huntingRepository.findAll().stream().map(hunting -> modelMapper.map(hunting, HuntingRespDTO.class)).collect(Collectors.toList());
    }

    public HuntingRespDTO saveHunting(HuntingReqDTO hunting) {
        return modelMapper.map(huntingRepository.save(modelMapper.map(hunting, Hunting.class)),HuntingRespDTO.class);

    }

    public HuntingRespDTO updateHunting(HuntingReqDTO hunting, Integer id) {
        Optional<Hunting> huntingOptional = huntingRepository.findById(id);
        if(huntingOptional.isPresent()){
            hunting.setId(huntingOptional.get().getId());
            return modelMapper.map(huntingRepository.save(modelMapper.map(hunting , Hunting.class)), HuntingRespDTO.class);

        }
        return null;
    }

    public Integer DeleteHunting(Integer huntingId){
        Optional<Hunting> exist = huntingRepository.findById(huntingId);

        if(exist.isPresent()){
            huntingRepository.deleteById(huntingId);
            return 1;
        }
        return 0;
    }
    public HuntingRespDTO findHunting(Integer huntingId) {
        Optional<Hunting> huntingOptional = huntingRepository.findById(huntingId);
        if (huntingOptional.isPresent()) {
            Hunting hunting = huntingOptional.get();
            return modelMapper.map(hunting, HuntingRespDTO.class);
        }
        return null;
    }


}
