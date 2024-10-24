package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import uz.bazaar.marketzone.dto.StoreDTO;
import uz.bazaar.marketzone.model.StoreEntity;

@Mapper(componentModel = "spring", uses = {FileModelMapper.class})
public abstract class StoreMapper {

//    @Mapping(target = "createDate", dateFormat = "dd.MM.yyyy")
    public abstract StoreDTO toDTO(StoreEntity storeEntity);

//    @Mapping(target = "createDate", dateFormat = "dd.MM.yyyy")
    public abstract StoreEntity toEntity(StoreDTO storeDTO);
}
