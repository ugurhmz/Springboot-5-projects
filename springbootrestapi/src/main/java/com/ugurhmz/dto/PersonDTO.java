package com.ugurhmz.dto;


import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> addressesStringList;

}
