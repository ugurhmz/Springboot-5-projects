package com.ugurhmz.service;


import com.ugurhmz.dto.UserSaveDTO;
import com.ugurhmz.enums.Role;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;


    // CREATE USER
    public UserSaveDTO createUser(UserSaveDTO userSaveDTO) {
        User user = modelMapper.map(userSaveDTO, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreationTime(LocalDateTime.now());

        return modelMapper.map(userRepository.save(user),UserSaveDTO.class);
    }
}
