package com.ugurhmz.service;


import com.ugurhmz.dto.RolesDTO;
import com.ugurhmz.dto.UserCreateDTO;
import com.ugurhmz.dto.UserDetailDTO;
import com.ugurhmz.dto.UserUpdateDTO;
import com.ugurhmz.exception.NotFoundException;
import com.ugurhmz.model.Roles;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    // CREATE USER
    @Transactional
    public UserCreateDTO  createUser(UserCreateDTO userCreateDTO) {
        User user = modelMapper.map(userCreateDTO, User.class);



        user.setCreatedAt(new Date());
        user.setCreatedBy("ADMIN");


        return modelMapper.map(userRepository.save(user), UserCreateDTO.class);
    }



    // GET USER BY ID
    public UserDetailDTO getUserById(Long id) {
       User user = userRepository.findById(id).orElseThrow( () -> new NotFoundException("Not Found exception"));
        return modelMapper.map(user, UserDetailDTO.class);
    }




    // GET LIST USERS
   @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<UserDetailDTO> getListUsers() {

        return  userRepository.findAll().stream().map( user -> modelMapper.map(user, UserDetailDTO.class)).collect(Collectors.toList());

    }


    // UPDATE USER
    @Transactional
    public UserUpdateDTO updateMyUser(Long id, UserUpdateDTO userUpdateDTO) {

       User user =  userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found User!!"));

       user.setFirstName(userUpdateDTO.getFirstName());
       user.setLastName(userUpdateDTO.getLastName());
       user.setUpdatedAt(new Date());
       user.setUpdatedBy("admin-updated");


       return modelMapper.map(userRepository.save(user), UserUpdateDTO.class);

    }


    // DELETE USER
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found!!"));
        userRepository.deleteById(user.getId());

    }
}
