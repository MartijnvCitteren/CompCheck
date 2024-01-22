package com.martijn.CompCheck.compensation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Integer> {
    List<Compensation> findAllByUserID(int userId);

}
