package com.example.coveringindex;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DBInit {

    private final TestMemberRepository testMemberRepository;

//    @PostConstruct
    @Transactional
    public void insertData() {
        for (int i = 0; i < 100_000; i++) {
            TestMember testMember = new TestMember("a" + i % 20, i % 10, "test" + i + "@gmail.com");
            testMemberRepository.save(testMember);
        }
    }
}
