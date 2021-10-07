package com.ugurhmz.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="T_USER")
@Data
public class User {

    @Id
    @SequenceGenerator(name="user_seq_gen", sequenceName="user_gen", initialValue=100, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq_gen")
    private Long id;

    @Column(length=100, name="first_name")
    private String firstName;

    @Column(length=200, name="last_name")
    private String lastName;

    @Column(length=200, name="e-mail")
    private String email;

}
