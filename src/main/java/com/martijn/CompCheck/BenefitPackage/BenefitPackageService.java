package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.cao.Cao;
import com.martijn.CompCheck.cao.CaoService;
import com.martijn.CompCheck.company.CompanyService;
import com.martijn.CompCheck.user.AppUserRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BenefitPackageService {


    private static BenefitPackageRepository benefitPackageRepository;
    private static CaoService caoService;
    private static CompanyService companyService;

    @Autowired
    public BenefitPackageService(BenefitPackageRepository benefitPackageRepository, CaoService caoService, CompanyService companyService) {
        this.benefitPackageRepository = benefitPackageRepository;
        this.caoService = caoService;
        this.companyService = companyService;
    }

    public static Float euro(Float f){
        Float euro = Math.round(f*100)/100.0f;
        return euro;
    }

    public void saveBenefitPackage(BenefitPackage benefitPackage){
        benefitPackageRepository.save(benefitPackage);
    }

    public BenefitPackage generateBenefitPackageWithCao(Integer companyId, Float monthlySalary, Integer weeklyHours){

        int caoId = companyService.giveCaoId(companyId);
        System.out.println("cao ID: " + caoId);
        Cao caoBenefits = caoService.GiveCaoById(companyService.giveCaoId(companyId));
        float partimePercentage = (float) weeklyHours / caoBenefits.getWeeklyWorkHours();

        // calculating values on a FT basis
        Float fixedYearlyBonus =  monthlySalary * caoBenefits.getBonus();
        Float grossSalaryYearly = (monthlySalary * 12) + fixedYearlyBonus;
        Integer obligatoryPtoHoursPerYear = (int)Math.floor(partimePercentage * (caoBenefits.getPtoHoursTotal() - caoBenefits.getPtoHoursSellable()));
        Integer sellablePtoHoursPerYear = (int) Math.floor(partimePercentage * caoBenefits.getPtoHoursSellable());
        Float pensionEmployerContribution = euro((grossSalaryYearly * caoBenefits.getPensionTotalPercentage()) * caoBenefits.getPensionEmployerPercentage());
        Float pensionEmployeeContribution = euro((grossSalaryYearly *  caoBenefits.getPensionTotalPercentage()) - pensionEmployerContribution);

        BenefitPackage myBenefitPackage = new BenefitPackage(null,
                                                                monthlySalary,
                                                                weeklyHours,
                                                                fixedYearlyBonus,
                                                                obligatoryPtoHoursPerYear,
                                                                sellablePtoHoursPerYear,
                                                                pensionEmployerContribution,
                                                                pensionEmployeeContribution,
                                                                grossSalaryYearly,
                                                                caoId,
                                                                companyId,
                                                                1);

        return myBenefitPackage;
    }

    public BenefitPackage findBenefitPackageById(int id){
        Optional <BenefitPackage> optionalBenefitPackage = benefitPackageRepository.findById(id);
        if(optionalBenefitPackage.isPresent()){
            return optionalBenefitPackage.get();
        }
        else{
            throw new RuntimeException("No benefitpackage found!");
        }
    }
}