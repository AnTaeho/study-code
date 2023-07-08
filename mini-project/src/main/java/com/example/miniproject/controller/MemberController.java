package com.example.miniproject.controller;

import com.example.miniproject.controller.dto.MemberResponse;
import com.example.miniproject.entity.Member;
import com.example.miniproject.service.MemberFacade;
import com.example.miniproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberFacade memberFacade;

    @PostMapping("/create")
    public MemberResponse createMember(@RequestBody String name) {
        Member member = memberService.createMember(name);
        return new MemberResponse(member);
    }

    @GetMapping("/{memberId}")
    public MemberResponse findMember(@PathVariable Long memberId) {
        Member member = memberService.findMember(memberId);
        return new MemberResponse(member);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberFacade.deleteMember(memberId);
    }
}
