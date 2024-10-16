package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.SubCategoryDTO;
import uz.bazaar.marketzone.model.Category;
import uz.bazaar.marketzone.model.SubCategory;

@Mapper(componentModel = "spring")
public abstract class SubCategoryMapper {

    public abstract SubCategoryDTO toDto(SubCategory subCategory);

    public abstract SubCategory toEntity(SubCategoryDTO dto);
}
