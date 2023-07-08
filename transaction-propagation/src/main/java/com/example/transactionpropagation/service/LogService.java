package com.example.transactionpropagation.service;

import com.example.transactionpropagation.entity.Log;
import com.example.transactionpropagation.entity.Member;
import com.example.transactionpropagation.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createLog(Member member) {
        logRepository.save(new Log(member));
    }

    public String findLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(IllegalArgumentException::new)
                .getLog();
    }
}
