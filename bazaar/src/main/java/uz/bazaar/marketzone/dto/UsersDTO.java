package uz.bazaar.marketzone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Integer id;
    @NotBlank(message = "firstName is null or not contains any character")
    private String firstName;
    @NotBlank(message = "lastName is null or not contains any character")
    private String lastName;
    //01.07.2000
    @Pattern(regexp = "[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}", message = "date format is incorrect") //dd.MM.yyyy
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createDate;
    private String username;
    @Size(min = 6, message = "Password must contain at least 6 character")
    private String password;
    private String phoneNumber;
    @Email(message = "Email is incorrect")
    private String email;
}
