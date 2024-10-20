package uz.bazaar.marketzone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.BazaarDto;
import uz.bazaar.marketzone.dto.ResponseDto;
import uz.bazaar.marketzone.dto.UsersDTO;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Users;
import uz.bazaar.marketzone.repository.UsersRepository;
import uz.bazaar.marketzone.service.mapper.UsersMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public ResponseDto<UsersDTO> addUsers(UsersDTO usersDTO){
        Users users = usersMapper.toEntity(usersDTO);
        try {
            usersRepository.save(users);
            return ResponseDto.<UsersDTO>builder()
                    .success(true)
                    .message("Users successfully saved!")
                    .data(usersMapper.toDto(users))
                    .build();
        }catch (Exception e){
            log.error("There was an error saving the Users: {}",e.getMessage());
            return ResponseDto.<UsersDTO>builder()
                    .message("Users not saved!")
                    .code(2)
                    .build();
        }
    }
}