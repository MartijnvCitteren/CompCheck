package com.martijn.CompCheck.compensation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compensation {
    private int id;
    private Float salaryGross;
    private int pto;
    private Float pensionDeposit;
    private Float salaryNett;
    private LocalDate calculationDate;
    private int userID;
    private int companyID;
}
