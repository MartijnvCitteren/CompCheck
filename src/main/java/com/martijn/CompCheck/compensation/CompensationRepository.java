package com.martijn.CompCheck.compensation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Integer> {
    List<Compensation> findAllById(Integer id);
}
