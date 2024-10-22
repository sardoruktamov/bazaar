package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.SubCategoryDTO;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Category;
import uz.bazaar.marketzone.model.SubCategory;
import uz.bazaar.marketzone.repository.CategoryRepository;
import uz.bazaar.marketzone.repository.SubCategoryRepository;
import uz.bazaar.marketzone.service.mapper.CategoryMapper;
import uz.bazaar.marketzone.service.mapper.SubCategoryMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final SubCategoryMapper subCategoryMapper;

    public ResponseDto<SubCategoryDTO> addSubCategory(SubCategoryDTO subCategoryDTO){
        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryDTO);
        try {
            subCategoryRepository.save(subCategory);
            return ResponseDto.<SubCategoryDTO>builder()
                    .success(true)
                    .message("SubCategory successfully saved!")
                    .data(subCategoryMapper.toDto(subCategory))
                    .build();
        }catch (Exception e){
            log.error("There was an error saving the subCategory: {}",e.getMessage());
            return ResponseDto.<SubCategoryDTO>builder()
                    .message("SubCategory not saved!")
                    .code(2)
                    .build();
        }
    }

    public ResponseDto<SubCategoryDTO> updateSubCategory(Integer id, SubCategoryDTO subCategoryDTO) {
        return subCategoryRepository.findById(id).map(subCategory -> {
            Category category = categoryRepository.findById(subCategoryDTO.getCategoryId().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found!!!"));

            subCategory.setName(subCategoryDTO.getName());
            subCategory.setCategoryId(category);
            subCategoryRepository.save(subCategory);

            SubCategoryDTO updatedSubCategoryDTO = new SubCategoryDTO(
//                    subCategory.getId(),
//                    subCategory.getName(),
//                    subCategory.getCategoryId().getId()
            );
            updatedSubCategoryDTO.setId(id);
            updatedSubCategoryDTO.setName(subCategoryDTO.getName());
            updatedSubCategoryDTO.setCategoryId(subCategoryDTO.getCategoryId());

            return ResponseDto.<SubCategoryDTO>builder()
                    .success(true)
                    .message("SubCategory updated successfully")
                    .code(0)
                    .data(updatedSubCategoryDTO)
                    .build();
        }).orElseGet(() -> ResponseDto.<SubCategoryDTO>builder()
                .success(false)
                .message("SubCategory not found")
                .code(-1)
                .build());
    }
    public ResponseDto<SubCategoryDTO> getById(Integer id){
        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);

        if (subCategory.isEmpty()){
            return ResponseDto.<SubCategoryDTO>builder()
                    .success(false)
                    .message("This SubCategory not found in " + id + " - id")
                    .code(-1)
                    .build();
        }

        SubCategoryDTO subCategoryDTO = subCategoryMapper.toDto(subCategory.get());

        return ResponseDto.<SubCategoryDTO>builder()
                .success(true)
                .message("OK")
                .data(subCategoryDTO)
                .build();
    }

    public ResponseDto<SubCategoryDTO> delete(Integer id){
        Optional<SubCategory> deltcat = subCategoryRepository.findById(id);
        if (deltcat.isEmpty()){
            return ResponseDto.<SubCategoryDTO>builder()
                    .code(-1)
                    .message("SubCategory not found!")
                    .build();
        }
        subCategoryRepository.deleteById(id);
        return ResponseDto.<SubCategoryDTO>builder()
                .success(true)
                .message("SubCategory successfully deleted!")
                .data(subCategoryMapper.toDto(deltcat.get()))
                .build();
    }
}
