package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.service.BazaarService;

@RestController
@RequestMapping("/bazaar")
@RequiredArgsConstructor
public class BazaarController {

    private final BazaarService bazaarService;
    @GetMapping("/{id}")
    public ResponseDto<BazaarDto> getId(@PathVariable Integer id){
        return bazaarService.getById(id);
    }

    @PostMapping
    public ResponseDto<BazaarDto> addBazaar(@Valid @RequestBody BazaarDto bazaarDto){
        return bazaarService.addBazaar(bazaarDto);
    }


}
