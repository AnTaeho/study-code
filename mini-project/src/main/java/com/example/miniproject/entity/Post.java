package com.example.miniproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Post() {
    }

    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
//        member.setPost(this);
    }
}
