package com.example.transactionpropagation.service;

import com.example.transactionpropagation.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;
    private final LogService logService;

    @Transactional
    public Member joinMemberWithLog(String name, int age) {
        Member member = memberService.join(name, age);
        logService.createLog(member);
        return member;
    }
}
