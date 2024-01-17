package com.martijn.CompCheck.cao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allCaos")
public class CaoController {
    private final CaoService caoService;

    @Autowired
    public CaoController(CaoService caoService){
        this.caoService = caoService;
    }

    @GetMapping
    public String showAllCao(Model model){
        caoService.allCaos();
        return "index";
    }


}
