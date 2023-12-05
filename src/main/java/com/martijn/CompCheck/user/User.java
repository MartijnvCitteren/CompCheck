package com.martijn.CompCheck.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//using lombok instead of writing all getters and setters.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String city;
    private int yearsOfExperience;
    private double salaryYearly;
    private String company;

}
