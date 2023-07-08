package com.example.miniproject;

import com.example.miniproject.entity.Member;
import com.example.miniproject.entity.Post;
import com.example.miniproject.repository.MemberRepository;
import com.example.miniproject.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @PostConstruct
    public void init() {
        Member member1 = new Member("name1");
        Member member2 = new Member("name2");
        Member member3 = new Member("name3");
        Member member4 = new Member("name4");

        memberRepository.saveAll(List.of(member1, member2, member3, member4));

        Post post1 = new Post("title1", "content1", member1);
        Post post2 = new Post("title2", "content2", member1);
        Post post3 = new Post("title3", "content3", member1);

        Post post4 = new Post("title4", "content4", member2);
        Post post5 = new Post("title5", "content5", member2);
        Post post6 = new Post("title6", "content6", member2);

        Post post7 = new Post("title7", "content7", member3);
        Post post8 = new Post("title8", "content8", member3);
        Post post9 = new Post("title9", "content9", member3);

        List<Post> postList = List.of(
                post1, post2, post3,
                post4, post5, post6,
                post7, post8, post9
        );

        postRepository.saveAll(postList);
    }
}
