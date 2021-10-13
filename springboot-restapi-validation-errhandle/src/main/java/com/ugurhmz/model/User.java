package com.ugurhmz.model;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="USERS")
public class User  extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="userName", nullable = false, length=75, unique=true)
    private String userName;


    @Column(name="first_name", nullable = false, length = 75)
    private String firstName;



    @Column(name="last_name", nullable = false, length= 200)
    private String lastName;



    @ManyToMany
    @JoinTable(name="user_roles",
            joinColumns = { @JoinColumn(name="user_id")},
            inverseJoinColumns = { @JoinColumn(name="role_id") })
    private Set<Roles> roles;




    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
