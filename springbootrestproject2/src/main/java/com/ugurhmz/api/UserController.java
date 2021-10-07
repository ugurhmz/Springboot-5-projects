package com.ugurhmz.api;


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
    public ResponseEntity<User> postUser(@RequestBody User user) {
           User createdUser =  userService.saveUser(user);
           System.out.println("created : "+user+"\n"+createdUser);

           return ResponseEntity.ok(createdUser);
    }


    // GET ALL USERS
    @GetMapping("/users-list")
    public ResponseEntity<List<User>> getUsersList(){
       List<User> usersList =  userService.findUsersList();

        System.out.println(ResponseEntity.ok());

       return ResponseEntity.ok(usersList);
    }



}
