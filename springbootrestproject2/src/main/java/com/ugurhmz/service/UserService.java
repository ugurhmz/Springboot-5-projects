package com.ugurhmz.service;


import com.ugurhmz.exception.ResourceNotFoundException;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    // SAVE USER
    public User saveUser(User user) {

        //Dummy data
        user.setCreatedAt(new Date());
        user.setCreatedBy("ADMIN");

        return userRepository.save(user);
    }


    // GET USERS LIST
    public List<User> findUsersList() {
       return userRepository.findAll();
    }


    // FIND BY USER ID
    public User findByUserId(Long id) {

        if(id != null || id >0){
            Optional<User>    getUserByID  =   userRepository.findById(id);
            System.out.println(getUserByID);

            if(getUserByID.isPresent()){
                return getUserByID.get();
            }
        }

        return  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    }
}
