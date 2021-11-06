package com.ugurhmz.repository.projection;


import com.ugurhmz.enums.DeviceTypes;

import java.time.LocalDateTime;




public interface PurchaseItem {


    //Verilen userId'ye  göre User'in satın aldıklarını gösterilmesi için
    String getName();
    DeviceTypes getType();
    Double getPrice();
    String getColor();
    LocalDateTime getPurchaseTime();

}
