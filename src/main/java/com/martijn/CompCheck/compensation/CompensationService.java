package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.BenefitPackage.BenefitPackage;
import com.martijn.CompCheck.tax.TaxServices;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.martijn.CompCheck.BenefitPackage.BenefitPackageService.euro;

@Service
public class CompensationService {

    private final int FULL_TIME_HOURS = 40;
    private final float WEEKS_PER_MONTH = 4.2f ; //effective workweeks in a year concidering chrismas ETC
    private final int MIN_PTO_HOURS = 200;
    private final CompensationRepository compensationRepository;
    private final TaxServices taxServices;



    public CompensationService(CompensationRepository compensationRepository){
        this.compensationRepository = compensationRepository;
        taxServices = new TaxServices();
    }

    public void saveCompensation(Compensation compensation){
        compensationRepository.save(compensation);
    }

    public Compensation makeCompensationCheck(BenefitPackage benefitPackage) {
        int hoursBP = benefitPackage.getHoursPerWeek();
        float salaryYearGrossExclSoldPto = convertFloatToFT(hoursBP,benefitPackage.getGrossSalaryYearly());

        float ptoTotal = convertFloatToFT(hoursBP , (float)(benefitPackage.getObligatoryPtoHoursPerYear()
                                                + benefitPackage.getSellablePtoHoursPerYear()));

        float numPtoHoursToSell = getMaxSellablePtoHours(
                                convertFloatToFT(hoursBP ,(float) benefitPackage.getObligatoryPtoHoursPerYear()),
                                convertFloatToFT(hoursBP, (float) benefitPackage.getSellablePtoHoursPerYear()));

        float extraSalaryFromSoldPto = sellPtOHoursConvertInEuro(numPtoHoursToSell,
                benefitPackage.getSalaryMonthly(), benefitPackage.getHoursPerWeek());

        float totalYearlySalaryGrossBP = salaryYearGrossExclSoldPto + extraSalaryFromSoldPto;

        float employeePensionDeposit = convertFloatToFT(hoursBP,benefitPackage.getApplicantPensionContribution());
        float totalPensionDeposit = convertFloatToFT(hoursBP, (benefitPackage.getEmployerPensionContribution())) + employeePensionDeposit;


        // Input for new compensation
        float salaryGrossYearly = euro(totalYearlySalaryGrossBP);
        int pto = Math.round(ptoTotal - numPtoHoursToSell);
        float pensionDeposit = euro(totalPensionDeposit);
        float salaryNettYearly = euro((taxServices.netRegularIncome(salaryYearGrossExclSoldPto,employeePensionDeposit)));
        LocalDate calculationDate = LocalDate.now();
        int userId = benefitPackage.getAppUserId();
        int companyId = benefitPackage.getCompanyId();

        Compensation compensation = new Compensation(null, salaryGrossYearly, pto, pensionDeposit, salaryNettYearly, calculationDate, userId, companyId);
        return compensation;
    }


    public int getMaxSellablePtoHours(float obligatoryPtoDays, float sellablePtoHours){
        float totalPto = obligatoryPtoDays + sellablePtoHours;
        float leftOverPto = totalPto - sellablePtoHours;

        if(leftOverPto >= MIN_PTO_HOURS){
            return Math.round(sellablePtoHours);
        }
        else{
            return Math.round(sellablePtoHours - (MIN_PTO_HOURS - leftOverPto));
        }

    }

    public float sellPtOHoursConvertInEuro(float ptoHoursToSell,float MonthlySalary, int hoursPerWeek){
        float hourlyRate = MonthlySalary / (hoursPerWeek * WEEKS_PER_MONTH);
        return euro(hourlyRate * ptoHoursToSell);
    }

    public int convertIntToFT(int weeklyHoursBenefitPackage, int toConvert){
        return (toConvert / weeklyHoursBenefitPackage) * FULL_TIME_HOURS;
    }
    public float convertFloatToFT(int weeklyHoursBenefitPackage, float toConvert){
        return (toConvert / weeklyHoursBenefitPackage) * FULL_TIME_HOURS;
    }

    public List<Compensation> getAllComparisonsByUserId(int id){
        return compensationRepository.findAllByUserID(id);
    }
}
