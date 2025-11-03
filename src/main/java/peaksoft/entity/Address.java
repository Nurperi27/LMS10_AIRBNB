package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address { //Source class when ---
                    //Target class when Agency, House
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", allocationSize = 1)
    @Column(name = "id_address")
    Long addressId;
    String city;
    String region;
    @Column(unique = true)
    String street;

    @OneToOne(mappedBy = "address", cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    Agency agency; //bi

    public Address(String city, String region, String street) {
        this.city = city;
        this.region = region;
        this.street = street;
    }
}
