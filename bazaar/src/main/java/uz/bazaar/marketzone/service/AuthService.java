package uz.bazaar.marketzone.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.RegistrationDTO;
import uz.bazaar.marketzone.enums.GeneralStatus;
import uz.bazaar.marketzone.enums.UsersRole;
import uz.bazaar.marketzone.exceptions.AppBadException;
import uz.bazaar.marketzone.model.Users;
import uz.bazaar.marketzone.repository.UserProfileRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private UsersRoleRepository profileRoleRepository;
    @Autowired
    private UserRoleService userRoleService;

    public String registration(RegistrationDTO dto){
        Optional<Users> optional = userProfileRepository.findByUsernameAndVisibleTrue(dto.getUsername());
        if (optional.isPresent()){
            Users userProfile = optional.get();
            if (userProfile.getStatus().equals(GeneralStatus.IN_REGISTRATION)){
                userRoleService.deleteRoles(userProfile.getId());
                // 1-usul
                log.error(userProfile.getFirstName() + " ---UCHIRILISHGA TAYYOR");
                userProfileRepository.delete(userProfile);
                log.error(userProfile.getFirstName() + " ---O'CHIB KETTIIIIII");
                // 2-usul
                //send sms/email orqali ro'yxatdan o'tishini davom ettirish
            }else {
                throw new AppBadException("Username already exists");
            }
        }

        Users entity = new Users();
        entity.setFirstName(dto.getFirstName());
        log.error(entity.getFirstName() + " ---  yangi yaratilindiiiii");
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setStatus(GeneralStatus.IN_REGISTRATION);
        entity.setVisible(true);
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setCreateDate(LocalDate.now());
        userProfileRepository.save(entity);
        userRoleService.create(entity.getId(), UsersRole.ROLE_USER);

        return "User muvoffaqiyatli saqlandi!";
    }


}
