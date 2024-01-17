package com.martijn.CompCheck.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT name FROM Company")
    List<String> findAllCompanyNames();

    Optional<Company> findByName(String name);
}
