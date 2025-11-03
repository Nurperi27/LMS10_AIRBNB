package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.HouseType;
import java.math.BigDecimal;

@Entity
@Table(name = "houses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class House { //Source class when Owner, Address
                //Target class when RentInfo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1)
    @Column(name = "id_house")
    Long houseId;
    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    HouseType houseType;
    BigDecimal price;
    double rating;
    String description;
    int room;
    boolean furniture;

    @ManyToOne(cascade = { //??
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    Owner owner; //bi

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    Address address; //uni

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    RentInfo rentInfo; //uni

    public House(HouseType houseType, BigDecimal price, double rating, String description, int room, boolean furniture) {
        this.houseType = houseType;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.room = room;
        this.furniture = furniture;
    }

    public boolean getFurniture() {
        return furniture;
    }
}
