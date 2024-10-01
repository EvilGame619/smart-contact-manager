package com.scm20.demo.forms;

import com.scm20.demo.validation.CheckPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.scm20.demo.validation.UniqueEmail;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Name should not be blank")
    @Size(max = 100,message = "Name should be atmost 100 characters")
    private String name;
    @Email(message = "Email not in correct format")
    @UniqueEmail
    private String email;
    @CheckPassword
    private String password;
    @Size(min = 8, max = 13, message = "Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "About is required")
    private String about;
}
