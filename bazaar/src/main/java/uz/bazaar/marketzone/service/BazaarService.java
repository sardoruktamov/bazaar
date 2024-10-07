package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.repository.BazaarRepository;
import uz.bazaar.marketzone.service.mapper.BazaarMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BazaarService {

    private final BazaarRepository bazaarRepository;
    private final BazaarMapper bazaarMapper;

    public ResponseDto<BazaarDto> getById(Integer id){
        Optional<Bazaar> bazaar = bazaarRepository.findById(id);

        if (bazaar.isEmpty()){
            return ResponseDto.<BazaarDto>builder()
                    .success(false)
                    .message("This bazaar not found in" + id + "- id")
                    .code(-1)
                    .build();
        }

        BazaarDto bazaarDto = bazaarMapper.toDto(bazaar.get());

        return ResponseDto.<BazaarDto>builder()
                .success(true)
                .message("OK")
                .data(bazaarDto)
                .build();

    }
}
