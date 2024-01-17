package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.company.Company;
import com.martijn.CompCheck.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/index")
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;
    private final CompanyService companyService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService, CompanyService companyService) {
        this.benefitPackageService = benefitPackageService;
        this.companyService = companyService;
    }

    @GetMapping
    public String selectCompany(Model model) {
        model.addAttribute("companies", companyService.getAllCompanyNames());
        model.addAttribute("selectCompany", new Company());
        return "index";
    }

    @PostMapping
    public String chooseCompanies(@ModelAttribute Company company, Model model) {
        model.addAttribute("selectCompany", new Company());
        String companyName = company.getName();

        System.out.println(String.format("Company 1: %s\n", companyName));

        if (companyName.contains("**Unknown**")) {
            return "redirect:/user/register";
        }
        else {
            Optional<Company> optionalCompany = companyService.findCompanyByName(companyName);
            if(optionalCompany.isPresent()){

            }


            return "redirect:/user/login";
        }
    }

    @GetMapping(path = "/package")
    public String fillBenefitPackagePage(Model model) {
        model.addAttribute("benefitPackageForm", new BenefitPackage());
        return "compare";
    }

}

