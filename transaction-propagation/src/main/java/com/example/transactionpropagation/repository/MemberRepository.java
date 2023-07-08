package com.example.transactionpropagation.repository;

import com.example.transactionpropagation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
