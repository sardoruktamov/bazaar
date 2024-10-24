package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bazaar.marketzone.dto.StoreDTO;
import uz.bazaar.marketzone.model.Store;

import static uz.bazaar.marketzone.utils.DateHelper.dateFormat;

@Mapper(componentModel = "spring", uses = {FileModelMapper.class})
public abstract interface StoreMapper {

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract StoreDTO toDTO(Store store);

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract Store toEntity(StoreDTO storeDTO);
}
