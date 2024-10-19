package uz.bazaar.marketzone.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import uz.bazaar.marketzone.model.Category;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO {

    private Integer id;

    private CategoryDto categoryId;

    private String name;
}
