package com.martijn.CompCheck.dto;

import java.time.LocalDate;

public record AppUserDto(
        String firstName,
        String lastName,
        String email,
        LocalDate dob,
        String city,
        Integer yearsOfExperience,
        Double salaryYearly,
        Integer companyId,
        String password) {
}
