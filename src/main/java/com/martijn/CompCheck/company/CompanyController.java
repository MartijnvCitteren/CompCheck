package com.martijn.CompCheck.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/company-pages")
public class CompanyController {

    private final CompanyService companyService;


    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }


}
