package com.martijn.CompCheck.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AppUserService {

    private static AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        AppUserService.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers(){
        return  appUserRepository.findAll();
    }

    public void addNewUser(AppUser appUser) {
        appUserRepository.save(appUser);
        System.out.println(appUser);
    }

    public void deleteUser(Integer id) {
        boolean exists = appUserRepository.existsById(id);
        if (exists){
            appUserRepository.deleteById(id);
        }
        else{
            throw new IllegalStateException("User with ID :" + id + " does not exists.");
        }
    }

    @Transactional
    public void updateUser(Integer id,
                                  String firstName,
                                  String lastName,
                                  String email,
                                  LocalDate dob,
                                  String city,
                                  Integer yearsOfExperience,
                                  Double salaryYearly, Integer companyId) {
        AppUser appUser = appUserRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "User with ID:"+ id + " doesn't exists"));

        if (firstName != null) {
            appUser.setFirstName(firstName);
        }

        if(lastName != null){
            appUser.setLastName(lastName);
        }

        if(email != null){
            appUser.setEmail(email);
        }

        if(dob != null){
            appUser.setDob(dob);
        }

        if(city != null){
            appUser.setCity(city);
        }

        if(yearsOfExperience != null){
            appUser.setYearsOfExperience(yearsOfExperience);
        }

        if(salaryYearly != null){
            appUser.setSalaryYearly(salaryYearly);
        }

        if(companyId != null){
            appUser.setCompanyId(companyId);
        }


    }




}
