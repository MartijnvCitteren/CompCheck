package com.martijn.CompCheck.BenefitPackage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BenefitPackage {
    protected String company;
    protected String cao;
    protected Double salary;
    protected String salaryPeriod;
    protected Integer hoursPerPeriod;
    protected Double fixedYearlyBonus;
    protected Integer obligatoryPtoHoursPerYear;
    protected Integer sellablePtoHoursPerYear;
    protected Double employerPensionContribution;
    protected Double applicantPensionContribution;
    protected Double nettSalaryYearly;
}
