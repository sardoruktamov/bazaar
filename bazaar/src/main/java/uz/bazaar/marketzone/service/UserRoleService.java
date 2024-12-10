package uz.bazaar.marketzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bazaar.marketzone.enums.UsersRole;
import uz.bazaar.marketzone.model.UserRoleEntity;
import uz.bazaar.marketzone.repository.UserRoleRepository;

import java.time.LocalDateTime;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public void create(Integer profileId, UsersRole role){
        UserRoleEntity entity = new UserRoleEntity();
        entity.setProfileId(profileId);
        entity.setRoles(role);
        entity.setCreatedDate(LocalDateTime.now());
        userRoleRepository.save(entity);
    }

    public void deleteRoles(Integer profileRoleId) {
        userRoleRepository.deleteByProfileId(profileRoleId);
    }
}
