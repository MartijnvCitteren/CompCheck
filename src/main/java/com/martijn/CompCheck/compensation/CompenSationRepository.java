package com.martijn.CompCheck.compensation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompenSationRepository extends JpaRepository<Compensation, Integer> {

}
