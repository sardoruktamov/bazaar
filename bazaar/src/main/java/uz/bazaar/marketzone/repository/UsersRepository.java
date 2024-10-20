package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
