package com.martijn.CompCheck.BenefitPackage;

import com.martijn.CompCheck.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BenefitPackageService {


    private static BenefitPackageRepository benefitPackageRepository;

    @Autowired
    public BenefitPackageService(BenefitPackageRepository benefitPackageRepository) {
        BenefitPackageService.benefitPackageRepository = benefitPackageRepository;
    }

    public List<String> getCompanyNames() {
        List<String> companyNames = new ArrayList<>();
        companyNames = Collections.singletonList(benefitPackageRepository.findAll().toString());
        return companyNames;
    }
}
