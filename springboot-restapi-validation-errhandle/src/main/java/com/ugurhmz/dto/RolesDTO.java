package com.ugurhmz.dto;


import com.ugurhmz.model.User;
import lombok.Data;

import java.util.Set;

@Data
public class RolesDTO {

    private String name;
    private Set<User> users;
}
