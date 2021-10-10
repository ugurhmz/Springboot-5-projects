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


    //UPDATE USER
    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserDTO userDTO)
    {

         UserDTO updatedUser =  userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean deletedUser = userService.deleteUser(id);
        return ResponseEntity.ok(deletedUser);
    }



}
