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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "salary")
    private Float salaryMonthly;

    @Column(name = "work_hours_weekly")
    private Integer hoursPerWeek;

    @Column(name = "fixed_bonus_yearly")
    private Float fixedYearlyBonus;

    @Column(name = "pto_hours_fixed_yearly")
    private Integer obligatoryPtoHoursPerYear;

    @Column(name = "pto_hours_sellable_yearly")
    private Integer sellablePtoHoursPerYear;

    @Column(name = "pension_employer_contribution")
    private Float employerPensionContribution;

    @Column(name = "pension_employee_contribution")
    private Float applicantPensionContribution;

    @Column(name = "gross_salary_yearly")
    private Float grossSalaryYearly;

    @Column(name = "caoid")
    private Integer caoId;

    @Column(name = "companyid")
    private Integer companyId;

    @Column(name = "userid")
    private Integer appUserId;

    public Integer getId() {
        return id;
    }

    public Float getSalaryMonthly() {
        return salaryMonthly;
    }

    public void setSalaryMonthly(Float salaryMonthly) {
        this.salaryMonthly = salaryMonthly;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Float getFixedYearlyBonus() {
        return fixedYearlyBonus;
    }

    public void setFixedYearlyBonus(Float fixedYearlyBonus) {
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

    public Float getEmployerPensionContribution() {
        return employerPensionContribution;
    }

    public void setEmployerPensionContribution(Float employerPensionContribution) {
        this.employerPensionContribution = employerPensionContribution;
    }

    public Float getApplicantPensionContribution() {
        return applicantPensionContribution;
    }

    public void setApplicantPensionContribution(Float applicantPensionContribution) {
        this.applicantPensionContribution = applicantPensionContribution;
    }

    public Float getGrossSalaryYearly() {
        return grossSalaryYearly;
    }

    public void setGrossSalaryYearly(Float grossSalaryYearly) {
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
