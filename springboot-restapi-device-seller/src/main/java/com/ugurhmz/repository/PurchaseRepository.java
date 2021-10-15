package com.ugurhmz.repository;


import com.ugurhmz.model.Purchase;
import com.ugurhmz.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {



    @Query("select "+
            "d.name as name, d.deviceType as type, p.price as price, " +
            "p.color as color, p.purchaseTime as purchaseTime "+
            "from Purchase p left join Device d on d.id = p.deviceId    "+
            "where p.userId = :userId")
    List<PurchaseItem>  findAllPurchasesOfUser(@Param("userId") Long userId);

}
