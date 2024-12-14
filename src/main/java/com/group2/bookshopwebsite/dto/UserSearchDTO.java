package com.group2.bookshopwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDTO {
    private Long categoryId;
    private String sortBy;
    private String keyword;

    public boolean isEmpty() {
        return categoryId == null && (keyword == null || keyword.isEmpty()) && (sortBy == null || sortBy.isEmpty());
    }
}
