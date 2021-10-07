package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.exception.ResourceNotFoundException;
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

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    // SAVE USER
    public UserDTO saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        //Dummy data
        user.setCreatedAt(new Date());
        user.setCreatedBy("ADMIN");
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }




    // GET USERS LIST
    public List<UserDTO> findUsersList() {
       List<User> usersList = userRepository.findAll();

       List<UserDTO> userDTOS =    usersList.stream()
                                            .map( user -> modelMapper.map(user, UserDTO.class) )
                                            .collect(Collectors.toList());
       System.out.println("userDTOS : "+userDTOS);
       return userDTOS;
    }





    // FIND BY USER ID
    public UserDTO findByUserId(Long id) {

        if(id != null || id >0){
            Optional<User>    getUserByID  =   userRepository.findById(id);
            System.out.println("getUserByID.get() --> "+getUserByID.get());

            if(getUserByID.isPresent()){
               return modelMapper.map(getUserByID.get(), UserDTO.class);
            }
        }
        return null;
    }





    // UPDATE USER
    public UserDTO updateMyUser(Long id, UserDTO userdto) {

        // 1- O id'li useri bul.
        Optional<User> getUserById =   userRepository.findById(id);

        // 2- id'si verilen kaydımız varsa, parametre olarak gelen nesnemizle  güncelleyelim.
        if (getUserById.isPresent()) {


            System.out.println("getUserById : "+getUserById.get());

            getUserById.get().setFirstName(userdto.getFirstName());
            getUserById.get().setLastName(userdto.getLastName());
            getUserById.get().setEmail(userdto.getEmail());
            getUserById.get().setUpdatedAt(new Date());
            getUserById.get().setUpdatedBy("Admin");

           return  modelMapper.map( userRepository.save(getUserById.get()), UserDTO.class);
        }

        return null;
    }
}














