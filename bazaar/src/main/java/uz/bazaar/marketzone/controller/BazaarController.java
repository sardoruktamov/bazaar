package uz.bazaar.marketzone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bazaar.marketzone.dto.ResponseDto;

@RestController
@RequestMapping("/bazaar")
@RequiredArgsConstructor
public class BazaarController {

    @GetMapping()
    public ResponseDto<String> test(){
        return ResponseDto.<String>builder()
                .success(true)
                .code(1)
                .data("Bismillahir roxmanir Roxiym")
                .message("ok")
                .build();
    }
}
