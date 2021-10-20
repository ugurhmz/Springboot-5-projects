package com.ugurhmz.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name="purchases")
public class Purchase {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name="user_id", nullable = false)
    private Long userId;



    @Column(name="device_id", nullable = false)
    private Long deviceId;



    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id",insertable = false, updatable = false)
    private User user;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Device device;



    @Column(name="price", nullable = false)
    private Double price;


    @Column(length=30, nullable = false)
    private String color;


    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;

}