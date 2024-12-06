package com.khaikin.airline.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private String phone;
    private LocalDate dob;

}
