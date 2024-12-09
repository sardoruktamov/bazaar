package uz.bazaar.marketzone.repository;

import org.springframework.data.repository.CrudRepository;
import uz.bazaar.marketzone.model.Users;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<Users, Integer> {

    // select * from users where username =? and visible=true  -> Query ko'rinishi
    Optional<Users> findByUsernameAndVisibleTrue(String username);
}
