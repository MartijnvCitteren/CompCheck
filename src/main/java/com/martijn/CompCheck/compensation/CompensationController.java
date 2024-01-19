package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.BenefitPackage.BenefitPackage;
import com.martijn.CompCheck.BenefitPackage.BenefitPackageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompensationController {

    private final CompensationService compensationService;
    private final BenefitPackageService benefitPackageService;

    public CompensationController(CompensationService compensationService, BenefitPackageService benefitPackageService){
        this.compensationService = compensationService;
        this.benefitPackageService = benefitPackageService;
    }


    @GetMapping("/result")
    public String showResult(@RequestParam int idBenefit, Model model){
        BenefitPackage myPackage = benefitPackageService.findBenefitPackageById(idBenefit);
        System.out.println(myPackage.toString());

        return "result";
    }

}
