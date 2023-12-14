package com.achchaimae.aftas.member;

import com.achchaimae.aftas.member.DTO.MemberReqDTO;
import com.achchaimae.aftas.member.DTO.MemberRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MemberRespDTO>> getMembers(){
        return ResponseEntity.ok().body(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<MemberRespDTO> save(@RequestBody MemberReqDTO member)
    {
        MemberRespDTO member1 = memberService.saveMember(member);
        return ResponseEntity.ok().body(member1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberRespDTO> update(@PathVariable Integer id, @RequestBody MemberReqDTO member)
    {
        return ResponseEntity.ok().body(memberService.updateMember(member,id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MemberRespDTO> getMemberById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(memberService.findMember(id));
    }

    @GetMapping("/findByAtt/{searchParam}")
    public ResponseEntity<MemberRespDTO> findMemberBySearchParam(@RequestParam String searchParam) {
        MemberRespDTO member = memberService.findMemberByAtt(searchParam);
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Integer id)
    {
        Integer deleted = memberService.DeleteMember(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("member deleted");
        }
        return ResponseEntity.badRequest().body("member not deleted");
    }


}
