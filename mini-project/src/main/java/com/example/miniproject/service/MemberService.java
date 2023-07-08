package com.example.miniproject.service;

import com.example.miniproject.entity.Member;
import com.example.miniproject.entity.Post;
import com.example.miniproject.repository.MemberRepository;
import com.example.miniproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Member createMember(String name) {
        return memberRepository.save(new Member(name));
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
    }

//    @Async
    public void deleteMember(Long memberId) {
//        Member member = findMember(memberId);
//        member.delete();
        memberRepository.deleteById(memberId);
    }
}
