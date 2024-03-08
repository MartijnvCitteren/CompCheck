package com.martijn.CompCheck.repository;

import com.martijn.CompCheck.model.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Integer> {
    Optional<Cao> findCaoById(Integer id);
}

