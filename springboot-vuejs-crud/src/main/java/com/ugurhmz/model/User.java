package com.ugurhmz.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name="user_seq_gen", sequenceName="user_gen", allocationSize = 1)
    @GeneratedValue(generator="user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length=100)
    private String name;

    @Column(length=200)
    private String email;

    @Column(length=50)
    private String password;


}
