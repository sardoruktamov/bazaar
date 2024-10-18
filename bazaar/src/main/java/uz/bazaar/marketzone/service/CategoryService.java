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

import java.util.Optional;

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

    // Kategoriya yangilash (PUT uchun)
    public ResponseDto<CategoryDto> updateCategory(Integer id, CategoryDto categoryDTO) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDTO.getName());
            categoryRepository.save(category);

            CategoryDto updatedCategoryDTO = new CategoryDto(category.getId(), category.getName());

            return ResponseDto.<CategoryDto>builder()
                    .success(true)
                    .message("Category updated successfully!")
                    .code(0)
                    .data(updatedCategoryDTO)
                    .build();
        }).orElseGet(() -> ResponseDto.<CategoryDto>builder()
                .success(false)
                .message("Category not found!")
                .code(-1)
                .build());
    }

    public ResponseDto<CategoryDto> delete(Integer id){
        Optional<Category> deltcat = categoryRepository.findById(id);
        if (deltcat.isEmpty()){
            return ResponseDto.<CategoryDto>builder()
                    .code(-1)
                    .message("Category not found!")
                    .build();
        }
        categoryRepository.deleteById(id);
        return ResponseDto.<CategoryDto>builder()
                .success(true)
                .message("Category successfully deleted!")
                .data(categoryMapper.toDto(deltcat.get()))
                .build();
    }
}
