package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import uz.bazaar.marketzone.dto.FileModelDTO;
import uz.bazaar.marketzone.model.FileModel;

import java.time.LocalDate;

@Mapper(componentModel = "spring", uses = {LocalDate.class})
public abstract class FileModelMapper {
    public abstract FileModelDTO toDTO(FileModel fileModel);

    public abstract FileModel toEntity(FileModelDTO fileModelDTO);
}
