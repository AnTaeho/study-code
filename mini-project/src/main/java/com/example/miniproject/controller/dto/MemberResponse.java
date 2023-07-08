package com.example.miniproject.controller.dto;

import com.example.miniproject.entity.Member;
import lombok.Data;

@Data
public class MemberResponse {

    private final Long id;
    private final String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
