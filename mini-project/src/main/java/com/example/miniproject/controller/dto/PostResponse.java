package com.example.miniproject.controller.dto;

import com.example.miniproject.entity.Post;
import lombok.Data;

@Data
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final MemberResponse memberResponse;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberResponse = new MemberResponse(post.getMember());
    }
}
