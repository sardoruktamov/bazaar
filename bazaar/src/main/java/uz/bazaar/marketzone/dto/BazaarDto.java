package uz.bazaar.marketzone.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BazaarDto {

    private Integer id;

    private String name;

    private String stir;

    private String address;

    private String director;

    private String phoneNumber;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createDate;
}
