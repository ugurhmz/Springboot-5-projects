package com.ugurhmz.dto;


import com.ugurhmz.model.Device;
import com.ugurhmz.model.User;
import lombok.Data;


import java.time.LocalDateTime;


@Data
public class PurchaseDTO {


    private Long id;
    private Long userId;
    private Long deviceId;
    private User user;
    private Device device;
    private Double price;
    private String color;
    private LocalDateTime purchaseTime;

}
