package com.ugurhmz.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="T_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name="user_seq_gen", sequenceName = "user_gen" ,allocationSize=1, initialValue = 100)
    @GeneratedValue(generator="user_seq_gen", strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(length=100)
    private String firstName;

    @Column(length=200)
    private String lastName;

    @Column(length=200)
    private String email;

}
