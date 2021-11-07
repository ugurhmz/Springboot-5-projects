package com.ugurhmz.service;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.security.UserPrincipal;
import com.ugurhmz.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {



    private  final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final ModelMapper modelMapper;

    // SIGN IN JWT
    public UserDTO signInReturnJWT(UserDTO signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())

        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);



        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);


        return modelMapper.map(signInUser, UserDTO.class);
    }


}
