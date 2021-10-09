package com.ugurhmz.api;


import com.ugurhmz.dto.UserDTO;
import com.ugurhmz.model.User;
import com.ugurhmz.service.UserService;
import com.ugurhmz.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<UserDTO>> getUsersList(){
       List<UserDTO> userDTOS = userService.findUsersList();
       return ResponseEntity.ok(userDTOS);
    }





   // GET USER BY ID
   @GetMapping("/{id}")
   public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.getUserwithId(id);
        return ResponseEntity.ok(userDTO);
    }





    // UPDATE USER
    @PutMapping("/{user-id}/update-user")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("user-id") Long id, @RequestBody UserDTO userDTO)
    {
       UserDTO updatedUserDTO =  userService.updateMyUser(id, userDTO);
       return ResponseEntity.ok(updatedUserDTO);
    }



    // DELETE USER
    @DeleteMapping("/{user-id}/delete-user")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("user-id") Long id)
    {
      Boolean deleteStatus = userService.deleteUser(id);

      return ResponseEntity.ok(deleteStatus);
    }


    //PAGINATION
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> pagination(
            @RequestParam  int currentPage,
            @RequestParam int pageSize)
    {

        return ResponseEntity.ok(userService.mypagination(currentPage, pageSize));
    }




    // PAGINATION TWO
    @GetMapping("/pagination/by-pageable")
    public ResponseEntity<List<UserDTO>> paginatoinByPageable(Pageable pageable){
        return ResponseEntity.ok(userService.paginationWithPageable(pageable));
    }





    // CUSTOMPAGE<DTO>    ~~> Gönderilen DTO'ya göre  kayıtları getirir.
    @GetMapping("/pagination/custompage")
    public ResponseEntity<CustomPage<UserDTO>> customPage(Pageable pageable){
        return ResponseEntity.ok(userService.customPagination(pageable));
    }


}

















