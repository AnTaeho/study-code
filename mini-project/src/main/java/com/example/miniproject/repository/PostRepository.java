package com.example.miniproject.repository;

import com.example.miniproject.entity.Member;
import com.example.miniproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteByMember(Member member);

    List<Post> findByMemberId(Long memberId);
}
