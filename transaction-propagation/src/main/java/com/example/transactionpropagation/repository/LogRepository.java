package com.example.transactionpropagation.repository;

import com.example.transactionpropagation.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
