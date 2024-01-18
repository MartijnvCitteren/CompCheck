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
            return "redirect:/index/error";
            // TO DO: redirect to Applied CAO-page?
        }
        else {
            Optional<Company> optionalCompany = companyService.findCompanyByName(companyName);
            if (optionalCompany.isPresent()) {
                int companyId = optionalCompany.get().getId();
                System.out.println("Company ID:" + companyId);
                System.out.println(optionalCompany.get().getName() + optionalCompany.get().getCao_id());
                Optional<Cao> optionalCao = caoService.findCaoById(optionalCompany.get().getCao_id());
                System.out.println(optionalCao.toString());

                if (optionalCao.isPresent()) {
                    redirectAttributes.addAttribute("companyId", companyId);
                    System.out.println("I run till redirect!");
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
    public String packageWithCao(@RequestParam int companyId, @ModelAttribute BenefitPackage benefitPackage, Model model){
        model.addAttribute("benefitPackageForm", new BenefitPackage());
        Float salary = benefitPackage.getSalaryMonthly();
        Integer weeklyHours = benefitPackage.getHoursPerWeek();

        BenefitPackage myBenefitPack = benefitPackageService.generateBenefitPackageWithCao(companyId, salary, weeklyHours);
        //benefitPackageService.saveBenefitPackage(myBenefitPack);

        System.out.println(myBenefitPack.toString());


        return "redirect:/index";
    }

}

