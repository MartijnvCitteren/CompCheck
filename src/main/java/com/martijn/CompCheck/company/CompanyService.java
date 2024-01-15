package com.martijn.CompCheck.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;


    @Autowired
    private CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<String> getAllCompanyNames() {
        return companyRepository.findAllCompanyNames();
    }
}
