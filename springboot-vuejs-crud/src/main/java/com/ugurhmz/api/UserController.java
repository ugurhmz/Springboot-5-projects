package com.ugurhmz.api;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    // CREATE NEW USER
    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // GET USERS LIST
    @GetMapping("/users-list")
    public ResponseEntity<List<UserDTO>> getUsersList(){
          List<UserDTO> userDTOS=  userService.findUsersList();
          return ResponseEntity.ok(userDTOS);
    }






}
