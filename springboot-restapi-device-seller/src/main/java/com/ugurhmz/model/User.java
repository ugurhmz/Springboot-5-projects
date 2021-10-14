package com.ugurhmz.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;



@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable = false)
    private String name;

    @Column(name="user_name", nullable=false, length=100, unique= true)
    private String username;

    @Column(length=75, nullable = false)
    private String password;


    @Column(name="creation_time", nullable  = false)
    private LocalDateTime creationTime;


    //roles
    @Enumerated(EnumType.ORDINAL)
    @Column(name="role", nullable = false)
    private Role role;


}
