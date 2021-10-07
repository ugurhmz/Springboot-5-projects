package com.ugurhmz.api;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;



    // CONSTRUCTOR INJECTION
    public UserController(UserService userService){
         this.userService = userService;
    }


    // CREATE USER
    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userDTO) {
        UserDTO createUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(createUser);
    }



    // GET ALL USERS
    @GetMapping("/users-list")
    public ResponseEntity<List<User>> getUsersList(){
       List<User> usersList =  userService.findUsersList();

        System.out.println(ResponseEntity.ok());

       return ResponseEntity.ok(usersList);
    }




    // GET USER BY ID
    @GetMapping("/{user-id}")
    public ResponseEntity<User> getUserById(@PathVariable("user-id") Long id){
      User getUserById =   userService.findByUserId(id);

      return ResponseEntity.ok(getUserById);
    }



    // UPDATE USER
    @PutMapping("/{user-id}/update-user")
    public ResponseEntity<User> putUpdateUser(
            @PathVariable("user-id") Long id,
            @RequestBody User user)
    {
        User updatedUser = userService.updateMyUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

}

















