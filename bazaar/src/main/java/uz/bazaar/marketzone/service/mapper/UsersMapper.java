package uz.bazaar.marketzone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.UsersDTO;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Users;

import static uz.bazaar.marketzone.utils.DateHelper.dateFormat;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract UsersDTO toDto(Users users);

    @Mapping(target = "createDate", dateFormat = dateFormat)
    public abstract Users toEntity(UsersDTO usersDTO);
}
