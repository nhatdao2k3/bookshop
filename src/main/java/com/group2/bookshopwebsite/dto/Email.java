package com.group2.bookshopwebsite.dto;

import lombok.*;

@Data
public class Email {
    private String to;
    private String subject;
    private String message;
}
