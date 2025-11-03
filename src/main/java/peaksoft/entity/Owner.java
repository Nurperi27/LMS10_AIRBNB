package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "owners")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"agencies", "houses"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Owner { //Source class when Agency
                    //Target class when House, RentInfo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_gen")
    @SequenceGenerator(name = "owner_gen", sequenceName = "owner_seq", allocationSize = 1)
    @Column(name = "id_owner")
    Long ownerId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(unique = true)
    String email;
    @Column(name = "date_of_birth")
    LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    Gender gender;

    @ManyToMany(cascade = {
            CascadeType.MERGE //обновляется agency если изменяем owner
    })
    List<Agency> agencies; //bi

    @OneToMany(mappedBy = "owner", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    List<House> houses; //bi

    public Owner(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
