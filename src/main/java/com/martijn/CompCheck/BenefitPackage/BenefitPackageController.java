package com.martijn.CompCheck.BenefitPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/benefit-package")
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService) {
        this.benefitPackageService = benefitPackageService;
    }
    @GetMapping
    public String apiTest() {
        BenefitPackage A = new BenefitPackage("x", "CAO", 4000.00, "monthly", 40, 1000.00, 240, 35, 120.00, 260.00, 3500.00);
        return A.toString();
    }






}
