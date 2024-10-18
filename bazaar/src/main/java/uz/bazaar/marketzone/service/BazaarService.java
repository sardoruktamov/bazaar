package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.repository.BazaarRepository;
import uz.bazaar.marketzone.service.mapper.BazaarMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                    .message("This bazaar not found in " + id + " - id")
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

    public ResponseDto<BazaarDto> addBazaar(BazaarDto bazaarDto){
        Bazaar bazaar = bazaarMapper.toEntity(bazaarDto);
        try {
            bazaarRepository.save(bazaar);
            return ResponseDto.<BazaarDto>builder()
                    .success(true)
                    .message("Bazaar successfully saved")
                    .data(bazaarMapper.toDto(bazaar))
                    .build();
        }catch (Exception e){
            log.error("There was an error saving the bazaar: {}",e.getMessage());
            return ResponseDto.<BazaarDto>builder()
                    .message("Bazaar not saved!")
                    .code(2)
                    .build();
        }
    }

    public ResponseDto<BazaarDto> updateBazaar(Integer id, BazaarDto bazaarDto) {
        // ID bo'yicha mavjud bazaarni topish
        Optional<Bazaar> optionalBazaar = bazaarRepository.findById(id);
        if (optionalBazaar.isEmpty()) {
            return ResponseDto.<BazaarDto>builder()
                    .success(false)
                    .message("Bazaar not found!")
                    .code(-1)
                    .build();
        }
        Bazaar existingBazaar = optionalBazaar.get();
        // Dto'dan Entityga o'girish
        Bazaar updatedBazaar = bazaarMapper.toEntity(bazaarDto);
        updatedBazaar.setId(existingBazaar.getId()); // id'ni saqlab qo'yish

        // Yangilangan entity'ni saqlash
        bazaarRepository.save(updatedBazaar);
        return ResponseDto.<BazaarDto>builder()
                .success(true)
                .message("Bazaar successfully updated!")
                .data(bazaarMapper.toDto(updatedBazaar))
                .build();
    }
    public ResponseDto<BazaarDto> delete(Integer id){
        Optional<Bazaar> deltBazaar = bazaarRepository.findById(id);
        if (deltBazaar.isEmpty()){
            return ResponseDto.<BazaarDto>builder()
                    .code(-1)
                    .message("Bazaar not found!")
                    .build();
        }
        bazaarRepository.deleteById(id);
        return ResponseDto.<BazaarDto>builder()
                .success(true)
                .message("Bazaar successfully deleted!")
                .data(bazaarMapper.toDto(deltBazaar.get()))
                .build();
    }

    public List<BazaarDto> findByParams(String stir, String name, String phoneNumber) {
        List<Bazaar> bazaars = bazaarRepository.findByParams(
                (stir != null && !stir.isEmpty()) ? stir : null,
                (name != null && !name.isEmpty()) ? name : null,
                (phoneNumber != null && !phoneNumber.isEmpty()) ? phoneNumber : null
        );
        return bazaars.stream()
                .map(bazaarMapper::toDto)
                .collect(Collectors.toList());
    }


}
