package uz.bazaar.marketzone.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.dto.RegistrationDTO;
import uz.bazaar.marketzone.enums.GeneralStatus;
import uz.bazaar.marketzone.exceptions.AppBadException;
import uz.bazaar.marketzone.model.Users;
import uz.bazaar.marketzone.repository.UserProfileRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private UsersRoleRepository profileRoleRepository;
//    @Autowired
//    private ProfileRoleService profileRoleService;

    public String registration(RegistrationDTO dto){
        Optional<Users> optional = userProfileRepository.findByUsernameAndVisibleTrue(dto.getUsername());
        if (optional.isPresent()){
            Users userProfile = optional.get();
            if (userProfile.getStatus().equals(GeneralStatus.IN_REGISTRATION)){
//                profileRoleService.deleteRoles(profile.getId());
                // 1-usul
                userProfileRepository.delete(userProfile);
                // 2-usul
                //send sms/email orqali ro'yxatdan o'tishini davom ettirish
            }else {
                throw new AppBadException("Username already exists");
            }
        }

        Users entity = new Users();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        entity.setStatus(GeneralStatus.IN_REGISTRATION);
        entity.setVisible(true);
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setCreateDate(LocalDate.now());
        userProfileRepository.save(entity);

        return "User muvoffaqiyatli saqlandi!";
    }


}
