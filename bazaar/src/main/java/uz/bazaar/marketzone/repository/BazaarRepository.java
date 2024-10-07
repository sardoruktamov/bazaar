package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.Bazaar;

@Repository
public interface BazaarRepository extends JpaRepository<Bazaar,Integer> {
}
