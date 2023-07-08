package com.example.miniproject.service;

import com.example.miniproject.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;
    private final PostService postService;

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberService.findMember(memberId);
        postService.deleteByMember(member);
        memberService.deleteMember(memberId);
    }
}
