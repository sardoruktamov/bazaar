package uz.bazaar.marketzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bazaar.marketzone.model.FileModel;

@Repository
public interface FileModelRepository  extends JpaRepository<FileModel,Integer> {
}
