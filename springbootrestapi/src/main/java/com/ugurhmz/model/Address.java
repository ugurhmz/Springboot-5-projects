package com.ugurhmz.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="P_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of={"id"})
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name="seq_person_address", allocationSize=1)
    @GeneratedValue(generator="seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="person_address", length=500 )
    private String personAdress;


    @Enumerated
    private AddressType addressType;


    @Column(name="person_status")
    private Boolean enabled;



    @ManyToOne
    @JoinColumn(name="person_address_id")
    private Person person;

    public enum AddressType {
        HOME_ADDRESS,
        WORKPLACE_ADDRESS,
        OTHER
    }

}
