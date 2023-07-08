package com.example.coveringindex;

import jakarta.persistence.*;

@Entity
public class TestMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    private String email;

    public TestMember(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public TestMember() {

    }
}
