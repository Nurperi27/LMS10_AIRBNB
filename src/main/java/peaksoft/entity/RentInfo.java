package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity
@Table(name = "rent_infos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentInfo { //Source class when Owner, Agency, House, Customer
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rentInfo_gen")
    @SequenceGenerator(name = "rentInfo_gen", sequenceName = "rentInfo-seq", allocationSize = 1)
    @Column(name = "id_rent_info")
    Long rentInfoId;
    @Column(name = "check_in")
    LocalDate checkInDate;
    @Column(name = "check_out")
    LocalDate checkOutDate;

    @ManyToOne
    Owner owner; //uni

    @ManyToOne
    Customer customer; //bi

    public RentInfo(LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
