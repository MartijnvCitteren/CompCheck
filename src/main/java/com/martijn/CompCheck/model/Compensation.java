package com.martijn.CompCheck.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compensation", schema = "public")
public class Compensation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "salary_gross_year_adjusted")
    private Float salaryGrossYearly;

    @Column(name = "pto_adjusted")
    private int pto;

    @Column(name = "pension_deposit_yearly")
    private Float pensionDeposit;

    @Column(name = "salary_nett_year")
    private Float salaryNettYearly;

    @Column(name = "date_calculation")
    private LocalDate calculationDate;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "company_id")
    private int companyID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getSalaryGrossYearly() {
        return salaryGrossYearly;
    }

    public void setSalaryGrossYearly(Float salaryGrossYearly) {
        this.salaryGrossYearly = salaryGrossYearly;
    }

    public int getPto() {
        return pto;
    }

    public void setPto(int pto) {
        this.pto = pto;
    }

    public Float getPensionDeposit() {
        return pensionDeposit;
    }

    public void setPensionDeposit(Float pensionDeposit) {
        this.pensionDeposit = pensionDeposit;
    }

    public Float getSalaryNettYearly() {
        return salaryNettYearly;
    }

    public void setSalaryNettYearly(Float salaryNettYearly) {
        this.salaryNettYearly = salaryNettYearly;
    }

    public LocalDate getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
