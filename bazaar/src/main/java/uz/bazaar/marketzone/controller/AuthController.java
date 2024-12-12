package uz.bazaar.marketzone.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/registration/verification/{token}")
    public ResponseDto<String> regVerification(@PathVariable("token") String token){
        return ResponseDto.<String>builder()
                .success(true)
                .message("OK")
                .data(authService.regVerification(token))
                .build();
    }
}
