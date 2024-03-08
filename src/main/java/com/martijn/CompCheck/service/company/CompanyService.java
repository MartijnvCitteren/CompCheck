package com.martijn.CompCheck.service.company;

import com.martijn.CompCheck.model.Company;
import com.martijn.CompCheck.repository.CompanyRepository;
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
            throw new RuntimeException("Company doesn't exist");
        }
    }

    public Company findCompanyById(int id){
        Optional <Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        else{
            throw new RuntimeException("Company not found");
        }
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
}
