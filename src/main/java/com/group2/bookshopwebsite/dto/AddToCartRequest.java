package com.group2.bookshopwebsite.dto;

import lombok.*;

@Data
public class AddToCartRequest {
    private Long productId;
    private int quantity;
}
