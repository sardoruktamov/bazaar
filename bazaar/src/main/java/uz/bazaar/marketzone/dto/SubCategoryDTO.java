package uz.bazaar.marketzone.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO {

    private Integer id;

    private Integer categoryId;

    private String name;
}
