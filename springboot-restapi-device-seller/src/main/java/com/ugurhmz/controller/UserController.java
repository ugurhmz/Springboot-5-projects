package com.ugurhmz.controller;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    // SAVE USER
    @PostMapping("/save-user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
      UserDTO createUser =   userService.createUser(userDTO);
      return ResponseEntity.ok(createUser);
    }

}
