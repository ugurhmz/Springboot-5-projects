package com.ugurhmz.service;


import com.ugurhmz.dto.PurchaseDTO;
import com.ugurhmz.exception.NotFoundException;
import com.ugurhmz.model.Purchase;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.PurchaseRepository;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepo;
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;



    //SAVE PURCHASE
    public PurchaseDTO savePurchase(PurchaseDTO purchaseDTO) {

        Purchase purchase = modelMapper.map(purchaseDTO, Purchase.class);
        purchase.setPurchaseTime(LocalDateTime.now());

        return modelMapper.map( purchaseRepo.save(purchase), PurchaseDTO.class );
    }




    // GET LIST PURCHASES LIST
    public List<PurchaseDTO> findPurchaseItemsOfUSer(Long userId){

      User user =  userRepo.findById(userId).orElseThrow(() -> new NotFoundException(userId+" Not Found!!"));

        return purchaseRepo.findAllPurchasesOfUser(user.getId())
                            .stream()
                            .map( item -> modelMapper.map(item, PurchaseDTO.class))
                            .collect(Collectors.toList());
    }




}
