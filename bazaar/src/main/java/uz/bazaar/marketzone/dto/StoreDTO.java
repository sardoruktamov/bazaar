package uz.bazaar.marketzone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Category;
import uz.bazaar.marketzone.model.FileModel;
import uz.bazaar.marketzone.model.Users;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Integer id;

    private BazaarDto bazaarDtoId;

    private String name;

    private UsersDTO userDtoId;

    private CategoryDto categoryDtoId;

    private String latitude;

    private String langitude;

    private String address;

    private String phoneNumber;

    private String telegramm;

    private String instagramm;

    private FileModelDTO image;

    private Boolean isActive = false;

//    @Pattern(regexp = "[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}", message = "date format is incorrect")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "create_date")
    private LocalDate createDate;

    private String target;
}
