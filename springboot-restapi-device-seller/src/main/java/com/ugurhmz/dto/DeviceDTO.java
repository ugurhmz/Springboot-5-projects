package com.ugurhmz.dto;


import com.ugurhmz.enums.DeviceTypes;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class DeviceDTO {

    private String name;
    private String description;
    private Double price;
    private LocalDateTime creationTime;
    private DeviceTypes deviceType;

}
