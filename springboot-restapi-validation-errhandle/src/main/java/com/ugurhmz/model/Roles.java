package com.ugurhmz.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ROLES")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;



}
