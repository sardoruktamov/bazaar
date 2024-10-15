package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Category;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public abstract CategoryDto toDto(Category category);

    public abstract Category toEntity(CategoryDto dto);
}
