package com.ugurhmz.controller;


import com.ugurhmz.dto.UserSaveDTO;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    // SAVE USER
    @PostMapping("/save-user")
    public ResponseEntity<UserSaveDTO> saveUser(@RequestBody UserSaveDTO userSaveDTO){
      UserSaveDTO createUser =   userService.createUser(userSaveDTO);
      return ResponseEntity.ok(createUser);
    }

}
