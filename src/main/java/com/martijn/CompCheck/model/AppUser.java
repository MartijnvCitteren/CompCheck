package com.martijn.CompCheck.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String city;
    private Integer yearsOfExperience;
    private Double salaryYearly;
    private Integer companyId;
    private String password;
}

