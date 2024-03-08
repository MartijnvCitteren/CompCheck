package com.martijn.CompCheck.repository;


import com.martijn.CompCheck.model.BenefitPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitPackageRepository extends JpaRepository <BenefitPackage, Integer> {

}
