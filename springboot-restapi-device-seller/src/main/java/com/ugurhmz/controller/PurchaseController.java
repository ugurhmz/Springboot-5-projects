package com.ugurhmz.controller;


import com.ugurhmz.dto.PurchaseDTO;
import com.ugurhmz.model.Purchase;
import com.ugurhmz.model.User;
import com.ugurhmz.security.UserPrincipal;
import com.ugurhmz.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;


    //SAVE PURCHASE
    @PostMapping
    public ResponseEntity<PurchaseDTO> savePurchase(@RequestBody PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(purchaseService.savePurchase(purchaseDTO), HttpStatus.CREATED );
    }




    // GET LIST PURCHASES LIST
    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> gettAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseService.findPurchaseItemsOfUSer(userPrincipal.getId()));
    }


}
