package com.martijn.CompCheck.controller;

import com.martijn.CompCheck.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "/company-pages")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService companyService) {
        this.companyService = companyService;
    }

}
