package com.martijn.CompCheck.cao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Integer> {
}

