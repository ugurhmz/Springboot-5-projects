package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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


    // UPDATE USER
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        // 1- id'li user bul.
        Optional<User> user =  userRepo.findById(id);

        // 2- id'si verilen kaydımız varsa, parametre olarak gelen nesnemizle güncelleyelim.
        if(user.isPresent()){
                user.get().setName(userDTO.getName());
                user.get().setEmail(userDTO.getEmail());
                user.get().setPassword(userDTO.getPassword());
                user.get().setUpdatedBy("Admin");
                user.get().setUpdatedAt(new Date());

         return modelMapper.map(userRepo.save(user.get()), UserDTO.class);
        }

        return null;
    }

    // DELETE USER
    public Boolean deleteUser(Long id){
       Optional<User>  user =   userRepo.findById(id);

       if(user.isPresent()){
            userRepo.deleteById(id);
            return true;
       }

       return false;
    }



}
