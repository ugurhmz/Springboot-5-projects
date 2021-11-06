package com.ugurhmz.service;


import com.ugurhmz.model.User;
import com.ugurhmz.security.UserPrincipal;
import com.ugurhmz.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {



    private  final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    // SIGN IN JWT
    public User signInReturnJWT(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())

        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }


}
