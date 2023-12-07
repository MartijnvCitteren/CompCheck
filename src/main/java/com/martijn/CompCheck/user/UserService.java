package com.martijn.CompCheck.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {

    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> getUsers(){
        return  userRepository.findAll();
    }

    public static void addNewUser(AppUser appUser) {
        userRepository.save(appUser);
        System.out.println(appUser);
    }
}
