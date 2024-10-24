package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.StoreDTO;
import uz.bazaar.marketzone.service.StoreService;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value ="/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseDto<StoreDTO> addStore(@Valid @ModelAttribute StoreDTO storeDTO,
                                          @RequestParam("image") MultipartFile image) {
        return storeService.addStore(storeDTO, image);
    }
}
