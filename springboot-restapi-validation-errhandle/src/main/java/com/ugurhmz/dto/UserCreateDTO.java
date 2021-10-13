package com.ugurhmz.dto;


import com.ugurhmz.customAnnotation.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
public class UserCreateDTO {

    @NotNull(message = "{rest-api-project3.constraints.userName.NotNull.message}")
    @Size(min = 4, max = 24, message = "{rest-api-project3.constraints.userName.Size.message}")
    @UniqueUserName
    private String userName;

    @NotNull(message = "{rest-api-project3.constraints.firstName.NotNull.message}")
    @Size(min = 2, max = 32, message = "{rest-api-project3.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{rest-api-project3.constraints.lastName.NotNull.message}")
    @Size(min = 3, max = 32, message = "{rest-api-project3.constraints.lastName.Size.message}")
    private String lastName;



}
