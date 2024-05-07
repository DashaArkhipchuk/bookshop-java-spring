package com.coursework.bookshop.author.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuthorRequest {
    @NotBlank
    @Pattern(regexp = "", message = "Field firstName should be ... ")
    private String firstName;
    @NotBlank
    private String lastName;

    private String biography;
    private String activityYears;
}
