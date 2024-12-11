package uz.bazaar.marketzone.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.bazaar.marketzone.enums.GeneralStatus;
import uz.bazaar.marketzone.model.Users;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<Users, Integer> {

    // select * from users where username =? and visible=true  -> Query ko'rinishi
    Optional<Users> findByUsernameAndVisibleTrue(String username);

    Optional<Users> findByIdAndVisibleTrue(Integer id);

    @Modifying
    @Transactional
    @Query("update Users set status =?2 where id =?1")
    void changeStatus(Integer id, GeneralStatus status);
}
