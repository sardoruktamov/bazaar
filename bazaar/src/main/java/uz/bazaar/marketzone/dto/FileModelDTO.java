package uz.bazaar.marketzone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FileModelDTO {

    private Integer id;

    private String name;
    private String ext;
    private String path;
    private String type;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createdAt;
}
