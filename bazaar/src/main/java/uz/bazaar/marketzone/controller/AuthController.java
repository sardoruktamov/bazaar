package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bazaar.marketzone.dto.RegistrationDTO;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    public ResponseDto<String> registration(@Valid @RequestBody RegistrationDTO dto){
        return ResponseDto.<String>builder()
                .success(true)
                .message("OK")
                .data(authService.registration(dto))
                .build();
    }
}
