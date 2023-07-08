package com.example.miniproject.controller;

import com.example.miniproject.controller.dto.PostResponse;
import com.example.miniproject.entity.Post;
import com.example.miniproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/create/{memberId}")
    public Post createPost(@RequestBody String title, @RequestBody String content, @PathVariable Long memberId) {
        return postService.createPost(title, content, memberId);
    }

    @GetMapping("/{postId}")
    public Post findPost(@PathVariable Long postId) {
        return postService.findPost(postId);
    }

    @GetMapping("/member/{memberId}")
    public List<PostResponse> findByMemberId(@PathVariable Long memberId) {
        return postService.findByMemberId(memberId)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
