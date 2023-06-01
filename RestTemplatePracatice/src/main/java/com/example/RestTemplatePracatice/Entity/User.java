package com.example.RestTemplatePracatice.Entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Long id;
    @NotNull(message = "UserName Required")
    @NotEmpty(message = "please enter username")
    private String userName;
    @NotNull(message = "emailId Required")
    @NotEmpty(message = "please enter emailId")
    private String emailId;
    @NotNull(message = "password Required")
    @NotEmpty(message = "please enter password")
    @Size(min = 8,message = "minimum 8")
    private String password;
}
