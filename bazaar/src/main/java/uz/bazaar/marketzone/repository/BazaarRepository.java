package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.Bazaar;

import java.util.List;

@Repository
public interface BazaarRepository extends JpaRepository<Bazaar,Integer> {

    @Query(value = "SELECT * FROM bazaar b WHERE " +
            "(:stir IS NULL OR b.stir ~* :stir) AND " +
            "(:name IS NULL OR b.name ~* :name) AND " +
            "(:phoneNumber IS NULL OR b.phone_number ~* :phoneNumber)", nativeQuery = true)
    List<Bazaar> findByParams(@Param("stir") String stir,
                              @Param("name") String name,
                              @Param("phoneNumber") String phoneNumber);



}
