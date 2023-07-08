package com.example.transactionpropagation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Log {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    private String log;

    public Log(Member member) {
        if (member.getName().equals("Ex")) {
            throw new IllegalArgumentException("예외 발생!!!");
        }
        this.log = member.getName() + "-" + member.getAge();
    }
}
