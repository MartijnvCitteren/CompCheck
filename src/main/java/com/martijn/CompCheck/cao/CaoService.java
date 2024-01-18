package com.martijn.CompCheck.cao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaoService {

    private final CaoRepository caoRepository;


    @Autowired
    public CaoService(CaoRepository caoRepository){
        this.caoRepository = caoRepository;
    }

    public Optional<Cao> findCaoById(Integer id){
        Optional<Cao> optionalCao = caoRepository.findCaoById(id);
        return optionalCao;
//        //if(optionalCao.isPresent()){
//
//        }
//        else{
//            throw new IllegalStateException("cao ID doesn't exists");
//        }
    }

    public Cao GiveCaoById(Integer id) {
        Optional<Cao> optionalCao = caoRepository.findCaoById(id);
        if (optionalCao.isPresent()) {
            return optionalCao.get();
        } else {
            throw new IllegalStateException("cao ID doesn't exists");
        }
    }




}
