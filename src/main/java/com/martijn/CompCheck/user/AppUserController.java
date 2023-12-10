package com.martijn.CompCheck.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @GetMapping
    private List<AppUser> getUsers() {
        return appUserService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody AppUser appUser){
        appUserService.addNewUser(appUser);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUSer(@PathVariable("userId") Integer id){
    appUserService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dob,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer yearsOfExperience,
            @RequestParam(required = false) Double salaryYearly,
            @RequestParam(required = false) Integer companyId) {

        appUserService.updateUser(id, firstName, lastName, email, dob, city, yearsOfExperience, salaryYearly, companyId);
    }

}
