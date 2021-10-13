package com.ugurhmz.api;


import com.ugurhmz.dto.RolesDTO;
import com.ugurhmz.dto.UserCreateDTO;

import com.ugurhmz.dto.UserDetailDTO;
import com.ugurhmz.dto.UserUpdateDTO;
import com.ugurhmz.genericmessage.GenericResponse;
import com.ugurhmz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;




    // CREATE USER

    @PostMapping("/create-user")
    public ResponseEntity<Object> postCreateUser(
            @Valid @RequestBody UserCreateDTO userCreateDTO)
    {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created..."));
    }





    // GET USER BY ID
    @GetMapping("/user/{user-id}")
    public ResponseEntity<UserDetailDTO> getUserDetailById(
            @PathVariable("user-id") Long id )
    {
        UserDetailDTO  userDetaildto= userService.getUserById(id);
        return ResponseEntity.ok(userDetaildto);
    }





    // GET ALL USERS
    @GetMapping("/list-users")
    public ResponseEntity<List<UserDetailDTO>> getListUsers(){
        return ResponseEntity.ok(userService.getListUsers());
    }






    // UPDATE USER
    @PutMapping("/update-user/{user-id}")
    public ResponseEntity<Object> updateUser(
            @PathVariable("user-id") Long id,
            @Valid @RequestBody  UserUpdateDTO userUpdateDTO)
    {

       UserUpdateDTO updatedUser =  userService.updateMyUser(id, userUpdateDTO);
       return ResponseEntity.ok(updatedUser);
    }






    // DELETE USER
    @DeleteMapping("/delete-user/{user-id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse(id+" | User deleted "));
    }




}
