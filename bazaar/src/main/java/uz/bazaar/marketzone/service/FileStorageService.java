package uz.bazaar.marketzone.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.bazaar.marketzone.model.FileModel;
import uz.bazaar.marketzone.repository.FileStorageRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
public class FileStorageService {

    @Autowired
    public FileStorageRepository fileStorageRepository;
    private final String uploadDir = "uploads/";

    public FileStorageService() throws IOException {
        // Fayllarni saqlash uchun katalogni yaratish (agar mavjud bo'lmasa)
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public String saveAsFile(MultipartFile file) throws IOException {
        String path = "/testuchun";
        String folders = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        File filePath = new File(path + "/" + folders);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        String filename = String.format("%s/%s",filePath,UUID.randomUUID());
        Files.copy(file.getInputStream(), Path.of(filename));
        return filename;
    }

    public FileModel saveFile(MultipartFile file) throws IOException {
        // Fayl nomi va kengaytmasini olish
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.error("MALUMOT UCHUUUUUUN---- " + fileName + " ....estt-.." + ext);
        // Faylni saqlash yo'lini belgilash
        Path filePath = Paths.get(uploadDir, fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // FileModel obyektini yaratish
        FileModel fileModel = new FileModel();
        fileModel.setName(fileName);
        fileModel.setExt(ext);
        fileModel.setPath(saveAsFile(file));
        fileModel.setType(file.getContentType());
        fileModel.setCreatedAt(LocalDate.now());
        fileStorageRepository.save(fileModel);
        return fileModel;
    }
}
