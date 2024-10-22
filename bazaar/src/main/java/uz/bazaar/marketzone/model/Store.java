package uz.bazaar.marketzone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(generator = "bazaar_seq")
    @SequenceGenerator(name = "bazaar_seq", sequenceName = "bazaar_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bazaar_id")
    @Column(name = "bazaar_id", nullable = false)
    private Bazaar bazaarId;

    @NotNull(message = "name cannot be null")
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Column(name = "user_id", nullable = false)
    private Users userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @Column(name = "category_id", nullable = false)
    private Category categoryId;
    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "langitude", nullable = false)
    private String langitude;

    @NotNull(message = "address cannot be null")
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull(message = "Phone number cannot be null")
    @Column(name = "phone_number", nullable = false)
    @Size(min = 12, max = 14)
    private String phoneNumber;
    @Column(name = "telegramm")
    private String telegramm;

    @Column(name = "instagramm")
    private String instagramm;

    @Column(name = "image")
    private String image;

    @Column(name = "is_active", columnDefinition = "false")
    private Boolean isActive = false;

    //    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "create_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createDate;

    @Column(name = "target")
    private String target;
}
