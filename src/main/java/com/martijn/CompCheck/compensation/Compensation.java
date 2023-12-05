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
    private float salaryGross;
    private int pto;
    private float pensionDeposit;
    private float salaryNett;
    private LocalDate calculationDate;
    private int userID;
    private int companyID;
}
