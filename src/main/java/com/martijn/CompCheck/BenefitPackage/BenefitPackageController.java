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







}
