package com.martijn.CompCheck.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Company> findCompanyByName(String name){
        return companyRepository.findByName(name);
    }

    public int giveCaoId(int companyId){
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if(optionalCompany.isPresent()){
            return optionalCompany.get().getCao_id();
        }
        else{
            throw new RuntimeException("Comapny doesn't exist");
        }
    }
}
