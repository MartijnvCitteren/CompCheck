package com.martijn.CompCheck.repository;

import com.martijn.CompCheck.model.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Integer> {
    List<Compensation> findAllById(Integer id);
}
