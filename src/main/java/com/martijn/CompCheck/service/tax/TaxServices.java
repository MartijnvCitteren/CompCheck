package com.martijn.CompCheck.service.tax;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.martijn.CompCheck.service.benefitPackage.BenefitPackageService.euro;

public class TaxServices {

    private final float THRESHOLD_HIGHEST_RATE = 64400.00f;
    private final float HIGHEST_TAX_RATE = 0.495f;
    private final float THRESHOLD_MID_RATE = 35475.00f;
    private final float MID_TAX_RATE = 0.375f;
    private final float THRESHOLD_LOW_RATE = 1500.00f;
    private final float LOW_TAX_RATE = .20f;
    private final float BONUS_TAX_RATE = .51f;


    public Float netRegularIncome(float grossYearlySalaryWithoutPensionDeduction, float pension) {
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


        if (grossYearly > THRESHOLD_LOW_RATE) {
            float taxedAmount = grossYearly - THRESHOLD_LOW_RATE;
            totalTax = totalTax + (taxedAmount * LOW_TAX_RATE);
        }

        return euro(originalGrossSalary - totalTax);
    }

    float netBonusIncome(float bonus) {
        float netPercentage = 1 - BONUS_TAX_RATE;
        return euro(bonus * netPercentage);
    }
}
