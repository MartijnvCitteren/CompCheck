package com.martijn.CompCheck.BenefitPackage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BenefitPackage {
    @Id
    @GeneratedValue
    private Integer id;
    private String company;
    private String cao;
    private Double salary;
    private String salaryPeriod;
    private Integer hoursPerPeriod;
    private Double fixedYearlyBonus;
    private Integer obligatoryPtoHoursPerYear;
    private Integer sellablePtoHoursPerYear;
    private Double employerPensionContribution;
    private Double applicantPensionContribution;
    private Double nettSalaryYearly;
}
