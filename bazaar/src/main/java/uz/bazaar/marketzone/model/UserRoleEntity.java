package uz.bazaar.marketzone.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import uz.bazaar.marketzone.enums.UsersRole;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", insertable = false,updatable = false)
    private Users users;

    @Column(name = "profile_id")
    private Integer profileId;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private UsersRole roles;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
