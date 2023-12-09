package com.achchaimae.aftas.level;

import com.achchaimae.aftas.level.DTO.LevelReqDTO;
import com.achchaimae.aftas.level.DTO.LevelRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LevelService implements LevelServiceInterface{

    private final LevelRepository levelRepository;

    @Autowired
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
    @Autowired
    ModelMapper modelMapper;

    public List<LevelRespDTO> getLevels() {
        return levelRepository.findAll().stream().map(level -> modelMapper.map(level, LevelRespDTO.class)).collect(Collectors.toList());
    }

    public LevelRespDTO saveLevel(LevelReqDTO level) {
        return modelMapper.map(levelRepository.save(modelMapper.map(level, Level.class)), LevelRespDTO.class);

    }
    public LevelRespDTO updateLevel(LevelReqDTO level, Integer id) {
        Optional<Level> levelOptional = levelRepository.findById(id);
        if(levelOptional.isPresent()){
            level.setCode(levelOptional.get().getCode());
            return modelMapper.map(levelRepository.save(modelMapper.map(level , Level.class)), LevelRespDTO.class);

        }
        return null;
    }


    public Integer DeleteLevel(Integer levelId){
        Optional<Level> exist = levelRepository.findById(levelId);

        if(exist.isPresent()){
            levelRepository.deleteById(levelId);
            return 1;
        }
        return 0;
    }

    public LevelRespDTO findLevel(Integer levelId) {
        Optional<Level> levelOptional = levelRepository.findById(levelId);
        if (levelOptional.isPresent()) {
            Level level = levelOptional.get();
            return modelMapper.map(level, LevelRespDTO.class);
        }
        return null;
    }


}
