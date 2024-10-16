package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.SubCategoryDTO;
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
