package com.martijn.CompCheck.repository;

import com.martijn.CompCheck.service.tax.TaxServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <TaxServices.AppUser, Integer>{
    Optional<TaxServices.AppUser> findByEmailEqualsIgnoreCase(String email);
}
