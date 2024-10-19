package uz.bazaar.marketzone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(generator = "subcategory_seq")
    @SequenceGenerator(name = "subcategory_seq", sequenceName = "subcategory_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @NotNull(message = "name cannot be null")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
