package com.martijn.CompCheck.BenefitPackage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "benefitpackage", schema = "public")
public class BenefitPackage {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "salary")
    private Double salaryMonthly;

    @Column(name = "work_hours_weekly")
    private Integer hoursPerWeek;

    @Column(name = "fixed_bonus_yearly")
    private Double fixedYearlyBonus;

    @Column(name = "pto_hours_fixed_yearly")
    private Integer obligatoryPtoHoursPerYear;

    @Column(name = "pto_hours_sellable_yearly")
    private Integer sellablePtoHoursPerYear;

    @Column(name = "pension_employer_contribution")
    private Double employerPensionContribution;

    @Column(name = "pension_employee_contribution")
    private Double applicantPensionContribution;

    @Column(name = "gross_salary_yearly")
    private Double grossSalaryYearly;

    @Column(name = "caoid")
    private Integer caoId;

    @Column(name = "companyid")
    private Integer companyId;

    @Column(name = "userid")
    private Integer appUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalaryMonthly() {
        return salaryMonthly;
    }

    public void setSalaryMonthly(Double salaryMonthly) {
        this.salaryMonthly = salaryMonthly;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Double getFixedYearlyBonus() {
        return fixedYearlyBonus;
    }

    public void setFixedYearlyBonus(Double fixedYearlyBonus) {
        this.fixedYearlyBonus = fixedYearlyBonus;
    }

    public Integer getObligatoryPtoHoursPerYear() {
        return obligatoryPtoHoursPerYear;
    }

    public void setObligatoryPtoHoursPerYear(Integer obligatoryPtoHoursPerYear) {
        this.obligatoryPtoHoursPerYear = obligatoryPtoHoursPerYear;
    }

    public Integer getSellablePtoHoursPerYear() {
        return sellablePtoHoursPerYear;
    }

    public void setSellablePtoHoursPerYear(Integer sellablePtoHoursPerYear) {
        this.sellablePtoHoursPerYear = sellablePtoHoursPerYear;
    }

    public Double getEmployerPensionContribution() {
        return employerPensionContribution;
    }

    public void setEmployerPensionContribution(Double employerPensionContribution) {
        this.employerPensionContribution = employerPensionContribution;
    }

    public Double getApplicantPensionContribution() {
        return applicantPensionContribution;
    }

    public void setApplicantPensionContribution(Double applicantPensionContribution) {
        this.applicantPensionContribution = applicantPensionContribution;
    }

    public Double getGrossSalaryYearly() {
        return grossSalaryYearly;
    }

    public void setGrossSalaryYearly(Double grossSalaryYearly) {
        this.grossSalaryYearly = grossSalaryYearly;
    }

    public Integer getCaoId() {
        return caoId;
    }

    public void setCaoId(Integer caoId) {
        this.caoId = caoId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }
}
