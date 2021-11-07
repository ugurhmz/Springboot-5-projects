package com.ugurhmz.controller;


import com.ugurhmz.dto.UserDTO;

import com.ugurhmz.enums.Role;
import com.ugurhmz.security.UserPrincipal;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    // SAVE USER
    @PostMapping("/save-user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
      UserDTO createUser =   userService.createUser(userDTO);
      return ResponseEntity.ok(createUser);
    }



    // CHANGE ROLE
    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
         userService.updateRole(role, userPrincipal.getUsername());
         return ResponseEntity.ok(true);
    }

}
