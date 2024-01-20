package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.BenefitPackage.BenefitPackage;
import com.martijn.CompCheck.BenefitPackage.BenefitPackageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class CompensationController {

    private final CompensationService compensationService;
    private final BenefitPackageService benefitPackageService;

    public CompensationController(CompensationService compensationService, BenefitPackageService benefitPackageService){
        this.compensationService = compensationService;
        this.benefitPackageService = benefitPackageService;
    }

    @GetMapping("/result")
    public String showResult( @RequestParam int idBenefit, Model model){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        BenefitPackage myPackage = benefitPackageService.findBenefitPackageById(idBenefit);
        Compensation compensation = compensationService.makeCompensationCheck(myPackage);
        compensationService.saveCompensation(compensation);

        float yearlySalary = compensation.getSalaryGrossYearly();
        String salary = format.format(yearlySalary);

        System.out.println(format.format(yearlySalary));


        model.addAttribute("salary", salary);

        return "result";
    }

    @GetMapping("/my-comparisons")
    public String showAllComparisons(Model model, @CookieValue("userID") String id){
        List<Compensation> compensations = compensationService.getAllComparisonsByUserId(Integer.parseInt(id));
        model.addAttribute("compensations", compensations);

        return "comparison-overview";
    }

}
