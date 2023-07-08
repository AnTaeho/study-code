package com.example.miniproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private MemberStatus status;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
//    private List<Post> posts = new ArrayList<>();

    public Member() {
    }

    public Member(String name) {
        this.name = name;
        this.status = MemberStatus.LIVE;
    }

//    public void setPost(Post post) {
//        this.posts.add(post);
//    }

    public void delete() {
        this.status = MemberStatus.DELETED;
    }
}
