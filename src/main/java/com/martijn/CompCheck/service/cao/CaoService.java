package com.martijn.CompCheck.service.cao;

import com.martijn.CompCheck.model.Cao;
import com.martijn.CompCheck.repository.CaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaoService {

    private final CaoRepository caoRepository;

    @Autowired
    public CaoService(CaoRepository caoRepository){
        this.caoRepository = caoRepository;
    }

    public Optional<Cao> findCaoById(Integer id) {
        Optional<Cao> optionalCao = caoRepository.findCaoById(id);
        return optionalCao;
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
