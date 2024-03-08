package com.martijn.CompCheck.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.martijn.CompCheck.service.BenefitPackageService.euro;

public class TaxServices {

    private final float THRESHOLD_HIGHEST_RATE = 64400.00f;
    private final float HIGHEST_TAX_RATE = 0.495f;
    private final float THRESHOLD_MID_RATE = 35475.00f;
    private final float MID_TAX_RATE = 0.375f;
    private final float THRESHOLD_LOW_RATE = 1500.00f;
    private final float LOW_TAX_RATE = .20f;
    private final float BONUS_TAX_RATE = .51f;


    public Float netRegularIncome(float grossYearlySalaryWithoutPensionDeduction, float pension){
        float originalGrossSalary = grossYearlySalaryWithoutPensionDeduction;
        float grossYearly = grossYearlySalaryWithoutPensionDeduction - pension;
        float totalTax = 0.00f;

        if (grossYearly > THRESHOLD_HIGHEST_RATE) {
            float taxedAmount = grossYearly - THRESHOLD_HIGHEST_RATE;
            totalTax = totalTax + (taxedAmount * HIGHEST_TAX_RATE);
            grossYearly = grossYearly - taxedAmount;
        }

        if (grossYearly > THRESHOLD_MID_RATE) {
            float taxedAmount = grossYearly - THRESHOLD_MID_RATE;
            totalTax = totalTax + (taxedAmount * MID_TAX_RATE);
            grossYearly = grossYearly - taxedAmount;
        }


        if (grossYearly > THRESHOLD_LOW_RATE)  {
            float taxedAmount = grossYearly - THRESHOLD_LOW_RATE;
            totalTax = totalTax + (taxedAmount * LOW_TAX_RATE);
            }

        return euro(originalGrossSalary - totalTax);
    }

    float netBonusIncome(float bonus){
        float netPercentage = 1 - BONUS_TAX_RATE;
        return euro(bonus * netPercentage);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name= "users", schema = "public")
    public static class AppUser {

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
        private Integer yearsOfExperience;

        @Column(name = "salary_year")
        private Double salaryYearly;

        @Column(name = "company_id")
        private Integer companyId;

        @Column(name = "password")
        private String password;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Integer getYearsOfExperience() {
            return yearsOfExperience;
        }

        public void setYearsOfExperience(Integer yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
        }

        public Double getSalaryYearly() {
            return salaryYearly;
        }

        public void setSalaryYearly(Double salaryYearly) {
            this.salaryYearly = salaryYearly;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
