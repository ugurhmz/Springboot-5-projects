package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import com.ugurhmz.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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



    // DLETE USER
    public Boolean deleteUser(Long id) {
       Optional<User>   getUserByIdForDelete =  userRepository.findById(id);

       if(getUserByIdForDelete.isPresent()){
          userRepository.deleteById(id);
          return true;
       }
        return false;
    }



    //PAGINATION
    public Page<User> mypagination(int currentPage, int pageSize){
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return userRepository.findAll(pageable);
    }



    // PAGINATION WITH Pageable & DTO ~~>  /project-two/user/pagination/by-pageable?page=0&size=5&sort=firstName
    public List<UserDTO> paginationWithPageable(Pageable pageable) {
        // 1- Listeyi komple al.
        Page<User> pageUsersList = userRepository.findAll(pageable);

        // Listeyi stream ile akışa sok, dtoya çevir, sonrada dto liste dönüştür.
        List<UserDTO> userDTOS = pageUsersList.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());

        return userDTOS;
    }





    // CUSTOMPAGE<DTO>
    public CustomPage<UserDTO> customPagination(Pageable pageable){
        Page<User> usersData = userRepository.findAll(pageable);
        System.out.println("usersData : "+usersData);

        UserDTO[] dtos = modelMapper.map(usersData.getContent(), UserDTO[].class);

        return new CustomPage<UserDTO>(usersData, Arrays.asList(dtos));
    }




}














