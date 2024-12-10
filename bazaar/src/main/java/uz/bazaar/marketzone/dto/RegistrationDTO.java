package uz.bazaar.marketzone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    @NotBlank(message = "firstName is null or not contains any character")
    private String firstName;
    @NotBlank(message = "lastName is null or not contains any character")
    private String lastName;
    @NotBlank(message = "username is null or not contains any character")
    private String username;
    @Size(min = 6, message = "Password must contain at least 6 character")
    private String password;
    @NotBlank(message = "phoneNumber is null or not contains any character")
    private String phoneNumber;
    @Email(message = "Email is incorrect")
    private String email;
}
