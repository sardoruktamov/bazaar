package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.SubCategoryDTO;
import uz.bazaar.marketzone.service.CategoryService;
import uz.bazaar.marketzone.service.SubCategoryService;

@RestController
@RequestMapping("/sub-category")
@RequiredArgsConstructor
public class SubCategoryController {

    public final SubCategoryService subCategoryService;

    @PostMapping
    public ResponseDto<SubCategoryDTO> addSubCategory(@Valid @RequestBody SubCategoryDTO subCategoryDto){
        return subCategoryService.addSubCategory(subCategoryDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<SubCategoryDTO> getId(@PathVariable Integer id){
        return subCategoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<SubCategoryDTO> deleteSubCategory(@PathVariable Integer id){
        return subCategoryService.delete(id);
    }
}
