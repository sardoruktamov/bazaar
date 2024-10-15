package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.Bazaar;
import uz.bazaar.marketzone.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT * FROM category c WHERE " +
            "(:name IS NULL OR c.name ~* :name) AND " , nativeQuery = true)
    List<Category> findByParams(@Param("name") String name);
}
