package uz.bazaar.marketzone.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BazaarDto {

    private String name;

    private String stir;

    private String address;

    private String director;

    private String phoneNumber;

    private Date createDate;
}
