package com.martijn.CompCheck.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//using lombok instead of writing all getters and setters.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users", schema = "public")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "city")
    private String city;

    @Column(name = "years_experience")
    private int yearsOfExperience;

    @Column(name = "salary_year")
    private double salaryYearly;

    @Column(name = "company_id")
    private int companyId;
}
