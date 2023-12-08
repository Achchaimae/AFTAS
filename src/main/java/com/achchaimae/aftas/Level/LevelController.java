//    package com.achchaimae.aftas.Level;
//
//    import com.achchaimae.aftas.Level.DTO.LevelReqDTO;
//    import com.achchaimae.aftas.Level.DTO.LevelRespDTO;
//    import com.achchaimae.aftas.Member.DTO.MemberReqDTO;
//    import com.achchaimae.aftas.Member.DTO.MemberRespDTO;
//    import org.modelmapper.ModelMapper;
//    import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.http.ResponseEntity;
//    import org.springframework.web.bind.annotation.*;
//
//    import java.util.List;
//
//    @RestController
//    @RequestMapping("level")
//    public class LevelController {
//        @Autowired
//        LevelService levelService;
//        @Autowired
//        ModelMapper modelMapper;
//
//        @GetMapping
//        public ResponseEntity<List<LevelRespDTO>> getLevels(){
//            return ResponseEntity.ok().body(levelService.getLevels());
//        }
//        @PostMapping
//        public ResponseEntity<LevelRespDTO> save(@RequestBody LevelReqDTO level)
//        {
//            LevelRespDTO level1 = levelService.saveLevel(level);
//            return ResponseEntity.ok().body(level1);
//        }
//        @PutMapping("/{id}")
//        public ResponseEntity<LevelRespDTO> update(@PathVariable Integer id, @RequestBody LevelReqDTO level)
//        {
//            return ResponseEntity.ok().body(levelService.updateLevel(level,id));
//        }
//        @GetMapping("/find/{id}")
//        public ResponseEntity<LevelRespDTO> getLevelById(@PathVariable Integer id)
//        {
//            return ResponseEntity.ok().body(levelService.findLevel(id));
//        }
//
//        @DeleteMapping("delete/{id}")
//        public ResponseEntity<String> deleteLevel(@PathVariable Integer id)
//        {
//            Integer deleted = levelService.DeleteLevel(id);
//            if(deleted == 1)
//            {
//                return ResponseEntity.ok().body("level deleted");
//            }
//            return ResponseEntity.badRequest().body("level not deleted");
//        }
//
//    }
package com.achchaimae.aftas.Level;

import com.achchaimae.aftas.Level.DTO.LevelReqDTO;
import com.achchaimae.aftas.Level.DTO.LevelRespDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService levelService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<LevelRespDTO>> getLevels() {
        List<LevelRespDTO> levels = levelService.getLevels();
        return ResponseEntity.ok().body(levels);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody LevelReqDTO levelReqDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        LevelRespDTO levelRespDTO = levelService.saveLevel(levelReqDTO);
        return ResponseEntity.ok().body(levelRespDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody LevelReqDTO levelReqDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        LevelRespDTO levelRespDTO = levelService.updateLevel(levelReqDTO, id);
        return ResponseEntity.ok().body(levelRespDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LevelRespDTO> getLevelById(@PathVariable Integer id) {
        LevelRespDTO levelRespDTO = levelService.findLevel(id);
        return ResponseEntity.ok().body(levelRespDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable Integer id) {
        Integer deleted = levelService.DeleteLevel(id);
        if (deleted == 1) {
            return ResponseEntity.ok().body("Level deleted");
        }
        return ResponseEntity.badRequest().body("Level not deleted");
    }
}