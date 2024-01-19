package com.martijn.CompCheck.compensation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compensation", schema = "public")
public class Compensation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "salary_gross_year_adjusted")
    private Float salaryGross;

    @Column(name = "pto_adjusted")
    private int pto;

    @Column(name = "pension_deposit_yearly")
    private Float pensionDeposit;

    @Column(name = "salary_nett_year")
    private Float salaryNett;

    @Column(name = "date_calculation")
    private LocalDate calculationDate;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "company_id")
    private int companyID;
}
