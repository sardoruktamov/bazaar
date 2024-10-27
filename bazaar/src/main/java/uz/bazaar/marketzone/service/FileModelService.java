package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.bazaar.marketzone.dto.FileModelDTO;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.model.FileModel;
import uz.bazaar.marketzone.repository.FileModelRepository;
import uz.bazaar.marketzone.repository.FileStorageRepository;
import uz.bazaar.marketzone.service.mapper.FileModelMapper;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FileModelService {

    public final FileModelMapper fileModelMapper;
    public final FileModelRepository fileModelRepository;
    public FileStorageRepository fileStorageRepository;
    public final FileStorageService fileStorageService;

    public ResponseDto<FileModelDTO> uploadFile(MultipartFile file) throws IOException {
        String filepath = fileStorageService.saveAsFile(file);

        FileModel fileModel = new FileModel();
        fileModel.setName(file.getOriginalFilename());
        fileModel.setExt(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        fileModel.setPath(filepath);
        fileModel.setCreatedAt(LocalDate.now());
        fileModelRepository.save(fileModel);

        return ResponseDto.<FileModelDTO>builder()
                .message("OK")
                .success(true)
                .data(fileModelMapper.toDTO(fileModel))
                .build();
    }
}
