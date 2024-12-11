package uz.bazaar.marketzone.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.enums.GeneralStatus;
import uz.bazaar.marketzone.model.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
