package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.processing.Pattern;
import java.util.List;

@Entity
@Table(name = "agencies")
//@Check(constraint = "phone_number like '+996%' and length(phone_number)=13")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"owners", "address", "rentInfos"}) //убираем ленивые поля, чтобы не столкнуться с ошибкой LazyInitializationException
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agency { //Source class when Addres
                    //Target class when Owner, RentInfo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen", sequenceName = "agency_seq", allocationSize = 1)
    @Column(name = "id_agency")
    Long agencyId;
    @Column(name = "agency_name")
    String agencyName;
    //@Pattern(reqexp = "\\+996\\d{9}", message = "Phone number must start with +996 and have 13 digits")
    @Column(name = "phone_number", length = 13, nullable = false, //not null
    columnDefinition = "varchar(13) check (phone_number like '+996%' and length(phone_number) = 13)")
            //columnDefinition - позволяет вставить любое sql выражение, к-рое будет выполнено при создании таблицы
            //varchar(13) - ограничен длиной 13 символов(для чистого sql на уровне бд, чтобы гарантировать физическое ограничение)
            //length(phone_number) = 13 - проверка(для JPA/Hibernate при генерации DDL)
    String phoneNumber;

    @ManyToMany(mappedBy = "agencies")
    List<Owner> owners; //bi

    @OneToOne(
        cascade = {CascadeType.PERSIST, //адрес сохраняется при сохранении agency
                    CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.REMOVE
    })
    Address address; //bi

    @OneToMany(cascade = {CascadeType.PERSIST, //когда agency сохраняется, сохряняются и rent info
    CascadeType.MERGE,
    CascadeType.REFRESH,
    CascadeType.REMOVE
    })
    List<RentInfo> rentInfos; //uni

    public Agency(String agencyName, String phoneNumber) {
        this.agencyName = agencyName;
        this.phoneNumber = phoneNumber;
    }
}
