package com.ugurhmz.dto;


import com.ugurhmz.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserSaveDTO {


    private String name;
    private String username;
    private String password;
    private LocalDateTime creationTime;
    private Role role;

}
