package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.BenefitPackage.BenefitPackage;
import com.martijn.CompCheck.BenefitPackage.BenefitPackageService;
import com.martijn.CompCheck.company.Company;
import com.martijn.CompCheck.company.CompanyService;
import com.martijn.CompCheck.tax.TaxServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class CompensationController {

    private final CompensationService compensationService;
    private final BenefitPackageService benefitPackageService;
    private final CompanyService companyService;
    private final TaxServices taxServices = new TaxServices();

    public CompensationController(CompensationService compensationService, BenefitPackageService benefitPackageService, CompanyService companyService){
        this.compensationService = compensationService;
        this.benefitPackageService = benefitPackageService;
        this.companyService = companyService;

    }

    @GetMapping("/result")
    public String showResult( @RequestParam int idBenefit, Model model){
        NumberFormat format = NumberFormat.getCurrencyInstance();

        BenefitPackage myPackage = benefitPackageService.findBenefitPackageById(idBenefit);
        Compensation compensation = compensationService.makeCompensationCheck(myPackage);
        compensationService.saveCompensation(compensation);
        int companyID = myPackage.getCompanyId();

        //Original BenefitPackage
        String companyName = companyService.findCompanyById(companyID).getName();
        String companyLocation = companyService.findCompanyById(companyID).getCity();
        int weeklyHoursBen = myPackage.getHoursPerWeek();
        int totalPtoHoursBen = myPackage.getSellablePtoHoursPerYear() + myPackage.getObligatoryPtoHoursPerYear();

        String totalPensionBenS = format.format(myPackage.getApplicantPensionContribution() + myPackage.getEmployerPensionContribution());
        String ownPensionContributionBenS = format.format(myPackage.getApplicantPensionContribution());

        String grossYearlyBenS = format.format(myPackage.getGrossSalaryYearly());
        String netYearlySalaryBenS = format.format(taxServices.netRegularIncome(myPackage.getGrossSalaryYearly(), myPackage.getApplicantPensionContribution()));

        model.addAttribute("companyName", companyName);
        model.addAttribute("companyLocation", companyLocation);
        model.addAttribute("weeklyHoursBen", weeklyHoursBen);
        model.addAttribute("totalPtoDaysBen", totalPtoHoursBen);
        model.addAttribute("totalPensionBenS", totalPensionBenS);
        model.addAttribute("ownPensionContributionBenS", ownPensionContributionBenS);
        model.addAttribute("grossYearlySalaryBens", grossYearlyBenS);
        model.addAttribute("netYearlySalaryBenS", netYearlySalaryBenS);


        //Compensation package
        String grossSalaryYearlyComp = format.format(compensation.getSalaryGrossYearly());
        int ptoHoursComp = compensation.getPto();
        String netComp = format.format(compensation.getSalaryNettYearly());

        model.addAttribute("grossSalaryYearlyComp", grossSalaryYearlyComp);
        model.addAttribute("ptoHoursComp", ptoHoursComp);
        model.addAttribute("netYearlySalaryComp", netComp);

        return "result";
    }

    @GetMapping("/my-comparisons")
    public String showAllComparisons(Model model, @CookieValue("userID") String id){
        List<Compensation> compensations = compensationService.getAllComparisonsByUserId(Integer.parseInt(id));
        List<Company> companies = companyService.getAllCompanies();

        model.addAttribute("compensations",compensations);
        model.addAttribute("companies", companies);

        return "comparison-overview";
    }

}
