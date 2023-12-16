package com.martijn.CompCheck.BenefitPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenefitPackageService {


    private static BenefitPackageRepository benefitPackageRepository;

    @Autowired
    public BenefitPackageService(BenefitPackageRepository benefitPackageRepository) {
        BenefitPackageService.benefitPackageRepository = benefitPackageRepository;
    }
}
