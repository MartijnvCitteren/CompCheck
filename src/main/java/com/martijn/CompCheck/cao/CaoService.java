package com.martijn.CompCheck.cao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaoService {

    private final CaoRepository caoRepository;


    @Autowired
    public CaoService(CaoRepository caoRepository){
        this.caoRepository = caoRepository;
    }

    public List<Cao> allCaos(){
        return caoRepository.findAll();
    }



}
