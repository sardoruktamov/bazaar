package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.service.BazaarService;

import java.util.List;

@RestController
@RequestMapping("/bazaar")
@RequiredArgsConstructor
public class BazaarController {

    private final BazaarService bazaarService;

    @PostMapping
    public ResponseDto<BazaarDto> addBazaar(@Valid @RequestBody BazaarDto bazaarDto){
        return bazaarService.addBazaar(bazaarDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<BazaarDto> getId(@PathVariable Integer id){
        return bazaarService.getById(id);
    }

    @GetMapping("/search")
    public List<BazaarDto> searchBazaars(@RequestParam(required = false) String stir,
                                         @RequestParam(required = false) String name,
                                         @RequestParam(required = false) String phoneNumber) {
        return bazaarService.findByParams(stir, name, phoneNumber);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<BazaarDto> deleteBazaar(@PathVariable Integer id){
        return bazaarService.delete(id);
    }

}
