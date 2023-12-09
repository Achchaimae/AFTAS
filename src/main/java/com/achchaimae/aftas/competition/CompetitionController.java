package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.competition.DTO.CompetitionRespDTO;
import com.achchaimae.aftas.member.DTO.MemberReqDTO;
import com.achchaimae.aftas.member.DTO.MemberRespDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("competition")
@Validated
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CompetitionRespDTO>> getCompetition(){
        return ResponseEntity.ok().body(competitionService.getCompetitions());
    }

    @PostMapping
    public ResponseEntity<CompetitionRespDTO> save(@Valid @RequestBody CompetitionReqDTO competition) {
        CompetitionRespDTO competition1 = competitionService.saveCompetition(competition);
        return ResponseEntity.ok().body(competition1);
    }

    @PutMapping("/{code}")
    public ResponseEntity<CompetitionRespDTO> update(@PathVariable String code, @RequestBody CompetitionReqDTO competition)
    {
        return ResponseEntity.ok().body(competitionService.updateCompetition(competition,code));
    }
    @GetMapping("/find/{code}")
    public ResponseEntity<CompetitionRespDTO> getCompetitionById(@PathVariable String code)
    {
        return ResponseEntity.ok().body(competitionService.findCompetition(code));
    }
    @DeleteMapping("delete/{code}")
    public ResponseEntity<String> deleteQuiz(@PathVariable String code)
    {
        Integer deleted = competitionService.DeleteCompetition(code);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("competition deleted");
        }
        return ResponseEntity.badRequest().body("compettion not deleted");
    }

}