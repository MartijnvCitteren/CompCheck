package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;
    //private final CompanyService companyService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService) {
        this.benefitPackageService = benefitPackageService;
        //this.companyService = companyService;
    }

    @GetMapping
    public String showBenefitPackagePage(Model model) {
        model.addAttribute("PackageOne", new BenefitPackage());
        //model.addAttribute("packageOne", companyService.getAllCompanyNames());
        return "index";
    }

//    @GetMapping
//    public String comparePackage(Model model) {
//        model.addAttribute("PackageOne", new BenefitPackage());
//        return "index";
//    }
}
