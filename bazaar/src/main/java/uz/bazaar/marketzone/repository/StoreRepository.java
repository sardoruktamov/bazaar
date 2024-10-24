package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {
}
