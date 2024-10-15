package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Category;
import uz.bazaar.marketzone.repository.CategoryRepository;
import uz.bazaar.marketzone.service.mapper.CategoryMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public ResponseDto<CategoryDto> addCategory(CategoryDto categoryDto){
        Category category = categoryMapper.toEntity(categoryDto);
        try {
            categoryRepository.save(category);
            return ResponseDto.<CategoryDto>builder()
                    .success(true)
                    .message("Category successfully saved!")
                    .data(categoryMapper.toDto(category))
                    .build();
        }catch (Exception e){
            log.error("There was an error saving the category: {}",e.getMessage());
            return ResponseDto.<CategoryDto>builder()
                    .message("Category not saved!")
                    .code(2)
                    .build();
        }
    }
}
