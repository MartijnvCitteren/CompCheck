package com.martijn.CompCheck.compensation;

import com.martijn.CompCheck.BenefitPackage.BenefitPackage;
import com.martijn.CompCheck.tax.TaxServices;
import org.springframework.stereotype.Service;

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

    public Compensation makeCompensationCheck(BenefitPackage benefitPackage) {
        int hoursBP = benefitPackage.getHoursPerWeek();

        float salaryGross = convertFloatToFT(hoursBP,benefitPackage.getGrossSalaryYearly());

        Compensation compensation = new Compensation();
        return compensation;

    }

    public int getMaxSellablePtoHours(int obligatoryPtoDays, int sellablePtoHours){
        int totalPto = obligatoryPtoDays + sellablePtoHours;
        int leftOverPto = totalPto - sellablePtoHours;

        if(leftOverPto >= MIN_PTO_HOURS){
            return sellablePtoHours;
        }
        else{
            return sellablePtoHours - (MIN_PTO_HOURS - leftOverPto);
        }

    }

    public float sellPtOHoursConvertInEuro(int ptoHoursToSell,float MonthlySalary, int hoursPerWeek){
        float hourlyRate = MonthlySalary / (hoursPerWeek * WEEKS_PER_MONTH);
        return euro(hourlyRate * ptoHoursToSell);
    }

    public int convertIntToFT(int weeklyHoursBenefitPackage, int toConvert){
        return (toConvert / weeklyHoursBenefitPackage) * FULL_TIME_HOURS;
    }
    public float convertFloatToFT(int weeklyHoursBenefitPackage, float toConvert){
        return (toConvert / weeklyHoursBenefitPackage) * FULL_TIME_HOURS;
    }



}
