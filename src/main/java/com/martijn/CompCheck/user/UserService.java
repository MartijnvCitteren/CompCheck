package com.martijn.CompCheck.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers(){
        return  List.of(
                new User(123,
                        "Martijn",
                        "van Citteren",
                        "martijn@gmail.com",
                        LocalDate.of(1991, Month.MARCH, 4),
                        "Leiden",
                        2,
                        5000.00,
                        "learning BV")
        );
    }
}
