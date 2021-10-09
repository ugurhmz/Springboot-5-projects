package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;


    // CREATE NEW USER
    public UserDTO createUser(UserDTO userDTO) {
       User user =  modelMapper.map(userDTO, User.class);

       user.setCreatedBy("ADMIN");
       user.setCreatedAt(new Date());

       return modelMapper.map(userRepo.save(user), UserDTO.class);
    }





    // LIST ALL USERS
    public List<UserDTO> findUsersList() {
        List<User> usersList =  userRepo.findAll();
        List<UserDTO> userDTOS =    usersList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());

        return userDTOS;

    }


}
