package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.FamilyStatus;
import peaksoft.enums.Gender;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"rentInfos"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer { //Target class when RentInfo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "id_customer")
    Long customerId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String email;
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
            //по умоолчанию Hibernate сохраняется данные Enum по индексу, как ordinal:(1-й элемент = 0, 2-й = 1, ...)
            //Поэтому нужно указать способ сохранения Enum в базу - @Enumerated(EnumType.STRING)
    Gender gender;
    String nationality;
    @Enumerated(EnumType.STRING)
    @Column(name = "family_status")
    FamilyStatus familyStatus;

    @OneToMany(mappedBy = "customer", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    List<RentInfo> rentInfos; //bi

    public Customer(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender,
                    String nationality, FamilyStatus familyStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.familyStatus = familyStatus;
    }
}
