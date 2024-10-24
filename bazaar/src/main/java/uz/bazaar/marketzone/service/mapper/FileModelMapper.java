package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import uz.bazaar.marketzone.dto.FileModelDTO;
import uz.bazaar.marketzone.model.FileModel;

@Mapper(componentModel = "spring")
public interface FileModelMapper {
    FileModelDTO toDTO(FileModel fileModel);

    FileModel toEntity(FileModelDTO fileModelDTO);
}
