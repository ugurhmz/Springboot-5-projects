package com.ugurhmz.service;


import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
}
