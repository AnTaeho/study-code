package com.example.springmailproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/send")
    public MailRequest sendTestMail(String email) {
        MailRequest mailTO = new MailRequest();
        mailTO.setAddress(email);
        mailTO.setTitle("안태호 님이 발송한 이메일입니다.");
        mailTO.setMessage("안녕하세요. 반가워요!");
        mailService.sendMail(mailTO);
        return mailTO;
    }
}
