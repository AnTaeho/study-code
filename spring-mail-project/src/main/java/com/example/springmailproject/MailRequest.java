package com.example.springmailproject;

import lombok.Data;

@Data
public class MailRequest {
    private String address;
    private String title;
    private String message;
}
