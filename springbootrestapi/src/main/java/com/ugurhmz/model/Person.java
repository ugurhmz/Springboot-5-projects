package com.ugurhmz.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="T_PERSON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
public class Person {

    @Id
    @SequenceGenerator(name="seq_person", allocationSize=1)
    @GeneratedValue(generator="seq_person", strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(length=100, name="firstName")
    private String firstName;

    @Column(length=200, name="lastName")
    private String lastName;

    @OneToMany
    @JoinColumn(name="person_address_id")
    private List<Address> addressesOfPersons;


}
