package com.ugurhmz.controller;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.service.AuthenticationService;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/authentication/")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    private final UserService userService;

    //UYE OL
    @PostMapping("sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO){

        if( userService.findByUserName(userDTO.getUsername()).isPresent()    ){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }


    //GIRIS YAP
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserDTO user) {

        return new ResponseEntity<>(authenticationService.signInReturnJWT(user), HttpStatus.OK);
    }


}


















