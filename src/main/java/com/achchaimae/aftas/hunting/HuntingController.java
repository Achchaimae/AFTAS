package com.achchaimae.aftas.hunting;

import com.achchaimae.aftas.hunting.dto.HuntingReqDTO;
import com.achchaimae.aftas.hunting.dto.HuntingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hunting")
public class HuntingController {

    @Autowired
    HuntingService huntingService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<HuntingRespDTO>> getMembers(){
        return ResponseEntity.ok().body(huntingService.getHuntings());
    }

    @PostMapping
    public ResponseEntity<HuntingRespDTO> save(@RequestBody HuntingReqDTO hunting)
    {
        HuntingRespDTO hunting1 = huntingService.saveHunting(hunting);
        if(hunting1 != null)
        {
            return  ResponseEntity.ok().body(hunting1);
        }
        return ResponseEntity.badRequest().body(null);
    }


//    public ResponseEntity<HuntingRespDTO> update(@PathVariable Integer id, @RequestBody HuntingReqDTO hunting)
//    {
//        return ResponseEntity.ok().body(huntingService.updateHunting(hunting,id));
//    }
    @PutMapping("/{id}")
    public ResponseEntity<HuntingRespDTO> update(@PathVariable Integer id, @RequestBody HuntingReqDTO hunting)
    {
        HuntingRespDTO hunting1 = huntingService.updateHunting(hunting,id);;
        if(hunting1 != null)
        {
            return  ResponseEntity.ok().body(hunting1);
        }
        return ResponseEntity.badRequest().body(null);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<HuntingRespDTO> getHuntingById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(huntingService.findHunting(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id)
    {
        Integer deleted = huntingService.DeleteHunting(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("hunting deleted");
        }
        return ResponseEntity.badRequest().body("hunting not deleted");
    }

}
