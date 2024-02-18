package com.achchaimae.aftas.fish;

import com.achchaimae.aftas.fish.dto.FishReqDTO;
import com.achchaimae.aftas.fish.dto.FishRespDTO;
import com.achchaimae.aftas.level.LevelRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fish")
@Validated
public class FishController {
    @Autowired
    FishService fishService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    LevelRepository levelRepository;

    @GetMapping
    public ResponseEntity<List<FishRespDTO>> getFishes() {
        List<FishRespDTO> fishes = fishService.getFishes();
        return ResponseEntity.ok().body(fishes);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody FishReqDTO fishReqDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        FishRespDTO fishRespDTO = fishService.saveFish(fishReqDTO);
        return ResponseEntity.ok().body(fishRespDTO);
    }


//    @PutMapping("/{fishName}")
//    public ResponseEntity<Object> update(@PathVariable String fishName, @Valid @RequestBody FishReqDTO fishReqDTO, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            List<String> errors = bindingResult.getFieldErrors().stream()
//                    .map(error -> error.getDefaultMessage())
//                    .collect(Collectors.toList());
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        FishRespDTO fishRespDTO = fishService.updateFish(fishReqDTO, fishName);
//        return ResponseEntity.ok().body(fishRespDTO);
//    }
@PutMapping("/{id}")
public ResponseEntity<Object> update(@PathVariable String id, @Valid @RequestBody FishReqDTO fishReqDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        List<String> errors = bindingResult.getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    FishRespDTO fishRespDTO = fishService.updateFish(fishReqDTO, id);
    return ResponseEntity.ok().body(fishRespDTO);
}


    @GetMapping("/find/{fishName}")
    public ResponseEntity<FishRespDTO> getFishById(@PathVariable String fishName) {
        FishRespDTO fishRespDTO = fishService.findFish(fishName);
        return ResponseEntity.ok().body(fishRespDTO);
    }

    @DeleteMapping("/delete/{fishName}")
    public ResponseEntity<String> deleteFish(@PathVariable String fishName) {
        Integer deleted = fishService.DeleteFish(fishName);
        if (deleted == 1) {
            return ResponseEntity.ok().body("Fish deleted");
        }
        return ResponseEntity.badRequest().body("Fish not deleted");
    }

}
