package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.CategoryDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.service.CategoryService;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping
    public ResponseDto<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
}
