package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.model.Bazaar;

import static uz.bazaar.marketzone.utils.DateHelper.dateFormat;

@Mapper(componentModel = "spring")
public abstract class BazaarMapper {

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract BazaarDto toDto(Bazaar bazaar);

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract Bazaar toEntity(BazaarDto dto);
}
