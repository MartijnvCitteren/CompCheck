package com.martijn.CompCheck.controller;

import com.martijn.CompCheck.service.CaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allCaos")
public class CaoController {
    private final CaoService caoService;

    @Autowired
    public CaoController(CaoService caoService){
        this.caoService = caoService;
    }


}
