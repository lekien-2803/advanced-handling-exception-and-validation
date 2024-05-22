package com.myproject.advanceexceptionhandlingvalidation.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreationRequest {
    @Size(min = 3, message = "INVALID_USERNAME")
    private String username;
    @Email(message = "INVALID_EMAIL")
    private String email;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
