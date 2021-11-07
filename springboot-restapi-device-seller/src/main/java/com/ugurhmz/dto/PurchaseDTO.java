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
    public User user;
    public Device device;
    private Double price;
    private String color;
    private LocalDateTime purchaseTime;

}
