package uz.bazaar.marketzone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class FileModel {

    @Id
    @GeneratedValue(generator = "fileModel_seq")
    @SequenceGenerator(name = "fileModel_seq", sequenceName = "fileModel_id_seq", allocationSize = 1)
    private Integer id;

    private String name;
    private String ext;
    private String path;
    private String type;
    private LocalDate createdAt;

}
