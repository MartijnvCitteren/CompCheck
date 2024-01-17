package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.cao.Cao;
import com.martijn.CompCheck.cao.CaoService;
import com.martijn.CompCheck.company.Company;
import com.martijn.CompCheck.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/index")
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;
    private final CompanyService companyService;
    private  final CaoService caoService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService, CompanyService companyService, CaoService caoService) {
        this.benefitPackageService = benefitPackageService;
        this.companyService = companyService;
        this.caoService = caoService;

    }

    @GetMapping
    public String selectCompany(Model model) {
        model.addAttribute("companies", companyService.getAllCompanyNames());
        model.addAttribute("selectCompany", new Company());
        return "index";
    }

    @PostMapping
    public String chooseCompanies(@ModelAttribute Company company, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("selectCompany", new Company());
        String companyName = company.getName();

        if (companyName.contains("**Unknown**")) {
            return "redirect:/user/register";
            // redirect to company info needs to be submitted + benefit package
        }
            Optional<Company> optionalCompany = companyService.findCompanyByName(companyName);
            if(optionalCompany.isPresent()){
                int companyId = optionalCompany.get().getId();
                System.out.println("Company ID:" + companyId);
                System.out.println(optionalCompany.get().getName() + optionalCompany.get().getCao_id());
                Optional<Cao> optionalCao = caoService.findCaoById(optionalCompany.get().getCao_id());
                System.out.println(optionalCao.toString());

                if(optionalCao.isPresent()){
                    int caoId = optionalCao.get().getId();
                    redirectAttributes.addAttribute("companyId", companyId);
                    System.out.println("I run till redirect!");
                    return "redirect:/index/packagecao";
                    // redirect to page where only salary and fte needs to be filler
                }
                else {
                    return "redirect:/user/login";
                    // redirect to all package info needs to be submitted
                }
            }
            else{
                return "redirect:/user/login";
                // redirect to company info needs to be submitted + benefit package
            }
        //return "redirect:/user/login";
    }

    @GetMapping("/packagecao")
    public String fillBenefitPackagePage(Model model) {
        model.addAttribute("benefitPackageForm", new BenefitPackage());

        return "compare";
    }

    @PostMapping("packagecao")
    public String retrieveBenefitPackage(@RequestParam int companyId, @ModelAttribute BenefitPackage benefitPackage, Model model){
        model.addAttribute("benefitPackageForm", new BenefitPackage());
        Double salary = benefitPackage.getSalaryMonthly();


        return "redirect:/index";
    }

}

