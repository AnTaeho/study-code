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
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Post createPost(String title, String content, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);

        return postRepository.save(new Post(title, content, member));
    }

    public Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Post> findByMemberId(Long memberId) {
        return postRepository.findByMemberId(memberId);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Async
    public void deleteByMember(Member member) {
        postRepository.deleteByMember(member);
    }
}
