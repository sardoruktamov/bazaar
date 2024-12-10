package uz.bazaar.marketzone.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import uz.bazaar.marketzone.model.UserRoleEntity;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Integer> {
    @Transactional
    @Modifying
    void deleteByProfileId(Integer integer);
}
