package uz.bazaar.marketzone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bazaar")
public class Bazaar {

    @Id
    @GeneratedValue(generator = "bazaar_seq")
    @SequenceGenerator(name = "bazaar_seq", sequenceName = "bazaar_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull(message = "name cannot be null")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "stir cannot be null")
    @Column(name = "stir", unique = true, nullable = false)
    @Size(min = 9, max = 9, message = "STIR must be exactly 9 characters long")
    private String stir;

    @NotNull(message = "address cannot be null")
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull(message = "director cannot be null")
    @Column(name = "director", nullable = false)
    private String director;

    @NotNull(message = "phoneNumber cannot be null")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "create_date")
    private Date createDate;
}
