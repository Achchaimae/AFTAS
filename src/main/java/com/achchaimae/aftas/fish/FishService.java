package com.achchaimae.aftas.fish;

import com.achchaimae.aftas.fish.DTO.FishReqDTO;
import com.achchaimae.aftas.fish.DTO.FishRespDTO;

import com.achchaimae.aftas.level.Level;
import com.achchaimae.aftas.level.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FishService implements FishServiceInterface {

    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;

    @Autowired
    public FishService(FishRepository fishRepository, LevelRepository levelRepository) {
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    Optional<Level> level ;
    public List<FishRespDTO> getFishes() {
        return fishRepository.findAll().stream().map(fish -> modelMapper.map(fish, FishRespDTO.class)).collect(Collectors.toList());
    }

public FishRespDTO saveFish(FishReqDTO fishReqDTO) {
    Fish fish = modelMapper.map(fishReqDTO,Fish.class);


    Level level = levelRepository.findById(fishReqDTO.getLevel_code()).orElse(null);
    if (level == null) {
//i need to add exeption
    }

    fish.setLevel(level);

    fish = fishRepository.save(fish);
    return modelMapper.map(fish, FishRespDTO.class);
}

public FishRespDTO updateFish(FishReqDTO fishReqDTO, String name) {
    Optional<Fish> fishOptional = fishRepository.findById(name);
    if (fishOptional.isPresent()) {
        Fish fish = fishOptional.get();
        fish.setName(fishReqDTO.getName());
        fish.setAverageWeight(fishReqDTO.getAverageWeight());

        Optional<Level> levelOptional = levelRepository.findById(fishReqDTO.getLevel_code());
        if (levelOptional.isPresent()) {
            fish.setLevel(levelOptional.get());
        }

        fish = fishRepository.save(fish);
        return modelMapper.map(fish, FishRespDTO.class);
    }
    return null;
}



    public Integer DeleteFish(String fishName){
        Optional<Fish> exist = fishRepository.findById(fishName);

        if(exist.isPresent()){
            fishRepository.deleteById(fishName);
            return 1;
        }
        return 0;
    }

    public FishRespDTO findFish(String fishName) {
        Optional<Fish> fishOptional = fishRepository.findById(fishName);
        if (fishOptional.isPresent()) {
            Fish fish = fishOptional.get();
            return modelMapper.map(fish, FishRespDTO.class);
        }
        return null;
    }






}
