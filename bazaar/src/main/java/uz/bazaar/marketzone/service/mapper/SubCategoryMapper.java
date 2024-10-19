package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.SubCategoryDTO;
import uz.bazaar.marketzone.model.Category;
import uz.bazaar.marketzone.model.SubCategory;

@Mapper(componentModel = "spring")
public abstract class SubCategoryMapper {

    @Autowired
    protected CategoryMapper categoryMapper;

    @Mapping(target = "categoryId", expression = "java(categoryMapper.toDto(subCategory.getCategoryId()))")
    public abstract SubCategoryDTO toDto(SubCategory subCategory);

    @Mapping(target = "categoryId", expression = "java(categoryMapper.toEntity(dto.getCategoryId()))")
    public abstract SubCategory toEntity(SubCategoryDTO dto);
}
