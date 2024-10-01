package com.scm20.demo.forms;

import com.scm20.demo.validation.UniqueEmail;
import com.scm20.demo.validation.ValidFile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class AddContactForm {
    @NotBlank(message = "Name should not be blank")
    @Size(max = 50,message = "Name should not exceed 50 characters")
    private String name;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email not in correct format")
    private String email;
    @NotBlank
    @Size(min = 10,max = 12, message = "Phone number should be in 10 to 12 digits")
    private String phoneNumber;
    @NotBlank(message = "Address should not be blank")
    private String address;
    @ValidFile(message = "File is not valid")
    private MultipartFile picture;

    private String description;

    private boolean favourite = false;

    private String websiteLink;

    private String linkedLink;
}
