package uz.bazaar.marketzone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.bazaar.marketzone.enums.GeneralStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "create_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private GeneralStatus status;  // ACTIVE, BLOCK ...

    // will be "false" when the profile is disabled
    @Column(name = "visible")
    private Boolean visible = Boolean.TRUE;

}
