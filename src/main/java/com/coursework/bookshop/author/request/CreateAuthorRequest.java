package com.coursework.bookshop.author.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuthorRequest {
    private String firstName;
    private String lastName;
    private String biography;
    private String activityYears;
}
