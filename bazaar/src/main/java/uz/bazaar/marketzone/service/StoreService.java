package uz.bazaar.marketzone.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.StoreDTO;
import uz.bazaar.marketzone.model.FileModel;
import uz.bazaar.marketzone.model.StoreEntity;
import uz.bazaar.marketzone.repository.StoreRepository;
import uz.bazaar.marketzone.service.mapper.StoreMapper;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private FileStorageService fileStorageService;

//    @Autowired
    private final StoreMapper storeMapper;

    // StoreEntity va faylni saqlash
    public ResponseDto<StoreDTO> addStore(StoreDTO storeDTO, MultipartFile image) {
        try {
            // Faylni saqlash va FileModelga saqlash
            FileModel fileModel = fileStorageService.saveFile(image);

            // StoreEntity obyektini DTO dan maplash
            StoreEntity storeEntity = storeMapper.toEntity(storeDTO);
            storeEntity.setImage(fileModel);

            // StoreEntity obyektini saqlash
            StoreEntity savedStoreEntity = storeRepository.save(storeEntity);

            // Saqlangan obyektni DTOga maplash
            StoreDTO savedStoreDTO = storeMapper.toDTO(savedStoreEntity);

            // Muvaffaqiyatli javob qaytarish
            return ResponseDto.<StoreDTO>builder()
                    .success(true)
                    .message("StoreEntity successfully saved!")
                    .code(0)
                    .data(savedStoreDTO)
                    .build();
        } catch (IOException e) {
            // Xatolik bo'lsa, ResponseDto bilan xatolik xabari qaytariladi
            return ResponseDto.<StoreDTO>builder()
                    .success(false)
                    .message("Failed to save store or file!")
                    .code(2) // 2: database error
                    .build();
        }
    }

}
