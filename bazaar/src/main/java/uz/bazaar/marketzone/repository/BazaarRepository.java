package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bazaar.marketzone.model.Bazaar;

public interface BazaarRepository extends JpaRepository<Bazaar,Integer> {
}
