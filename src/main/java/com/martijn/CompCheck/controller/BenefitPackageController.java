package com.martijn.CompCheck.controller;

import com.martijn.CompCheck.service.BenefitPackageService;
import com.martijn.CompCheck.model.Cao;
import com.martijn.CompCheck.service.CaoService;
import com.martijn.CompCheck.model.Company;
import com.martijn.CompCheck.service.CompanyService;
import com.martijn.CompCheck.model.BenefitPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(path="/index")
public class BenefitPackageController {

    private final BenefitPackageService benefitPackageService;
    private final CompanyService companyService;
    private  final CaoService caoService;

    @Autowired
    public  BenefitPackageController(BenefitPackageService benefitPackageService, CaoService caoService, CompanyService companyService) {
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
    public String chooseCompanies(@ModelAttribute Company company, Model model, RedirectAttributes redirectAttributes, @CookieValue("userID") String id) {
        model.addAttribute("selectCompany", new Company());
        String companyName = company.getName();

        if (companyName.contains("**Unknown**")) {
            return "redirect:/index/error";
            // TO DO: redirect to Applied CAO-page?
        }
        else {
            Optional<Company> optionalCompany = companyService.findCompanyByName(companyName);
            if (optionalCompany.isPresent()) {
                int companyId = optionalCompany.get().getId();
                Optional<Cao> optionalCao = caoService.findCaoById(optionalCompany.get().getCao_id());

                if (optionalCao.isPresent()) {
                    redirectAttributes.addAttribute("companyId", companyId);
                    return "redirect:/index/packagecao";
                }
                else{
                    return "error";
                    // TO DO: fill all information
                }
            }
            return "error";
        }

    }

    @GetMapping("/packagecao")
    public String fillBenefitPackagePage(Model model) {
        model.addAttribute("benefitPackageForm", new BenefitPackage());
        return "compare";
    }

    @PostMapping("packagecao")
    public String packageWithCao( @RequestParam int companyId, @ModelAttribute BenefitPackage benefitPackage,
                                  Model model, RedirectAttributes redirectAttributes, @CookieValue("userID") String id){
        model.addAttribute("benefitPackageForm", new BenefitPackage());
        Float salary = benefitPackage.getSalaryMonthly();
        Integer weeklyHours = benefitPackage.getHoursPerWeek();
        int userId = Integer.parseInt(id);

        BenefitPackage myBenefitPack = benefitPackageService.generateBenefitPackageWithCao(userId,companyId, salary, weeklyHours);
        benefitPackageService.saveBenefitPackage(myBenefitPack);
        int idBenefit = myBenefitPack.getId();

        redirectAttributes.addAttribute("idBenefit", idBenefit);

        return "redirect:/index/result";
    }
}

