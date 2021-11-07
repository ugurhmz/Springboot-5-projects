package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.enums.Role;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;



    // CREATE USER
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreationTime(LocalDateTime.now());

        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    // ALL USERS
    public List<UserDTO> paginationUsersList(Pageable pageable) {

        // 1-listeyi komple al.
        Page<User> usersList = userRepository.findAll(pageable);

        // 2- Listeyi stream ile akışa sok, dto'ya çevir. sonra dto listesine dönüştür.
        List<UserDTO> userDTOS =   usersList.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());

        return userDTOS;
    }


    // FIND BY USERNAME
    public Optional<User>  findByUserName(String username){
        return userRepository.findByUsername(username);
    }



    // UPDATE ROLE , @Transaction  -> required to update/delete query.
    @Transactional
    public void updateRole(Role newRole, String username ) {
        userRepository.updateUserRole(username, newRole);
    }



}
