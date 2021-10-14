package com.ugurhmz.model;


import com.ugurhmz.enums.DeviceTypes;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length=100, nullable = false)
    private String name;


    @Column(length=2500, nullable = false)
    private String description;


    @Column(nullable = false)
    private Double price;



    @Column(name="creation_time", nullable =  false)
    private LocalDateTime creationTime;



    //device type
    @Enumerated(value=EnumType.STRING)
    @Column(name="device_type", nullable = false)
    private DeviceTypes deviceType;






}
