package com.ugurhmz.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Data
public class UserUpdateDTO {


    @NotNull(message = "{rest-api-project3.constraints.firstName.NotNull.message}")
    @Size(min=2, max =32, message = "{rest-api-project3.constraints.firstName.Size.message}")
    private String firstName;


    @NotNull(message= "{rest-api-project3.constraints.lastName.NotNull.message}")
    @Size(min=3, max =32, message = "{rest-api-project3.constraints.lastName.Size.message}" )
    private String lastName;


}
