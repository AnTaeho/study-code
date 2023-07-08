package com.example.transactionpropagation.controller;

import com.example.transactionpropagation.entity.Member;
import com.example.transactionpropagation.service.LogService;
import com.example.transactionpropagation.service.MemberFacade;
import com.example.transactionpropagation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberFacade memberFacade;
    private final LogService logService;

    @PostMapping("/member/create")
    public Member joinMember(@RequestBody JoinRequest request) {
        return memberFacade.joinMemberWithLog(request.getName(), request.getAge());
    }

    @GetMapping("/member/{memberId}")
    public Member findMember(@PathVariable Long memberId) {
        return memberService.findMember(memberId);
    }

    @GetMapping("/log/{logId}")
    public String findLog(@PathVariable Long logId) {
        return logService.findLog(logId);
    }

}
