package com.martijn.CompCheck.BenefitPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService) {
        this.benefitPackageService = benefitPackageService;
    }

    @GetMapping("/index")
    public String benfitPackage(Model model) {
        return "index";
    }








}
