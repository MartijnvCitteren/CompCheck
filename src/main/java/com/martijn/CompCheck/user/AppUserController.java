package com.martijn.CompCheck.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    //testing Thymeleaf
    @GetMapping("/test1")
    public String showHelloPage() {
        return "helloPage.html";
    }


    @GetMapping("/all")
    private List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    private Optional<AppUser> getAppUser(@PathVariable Integer id) {
        return appUserService.getAppUserById(id);
    }

    @PostMapping("/newuser")
    public void registerNewUser(@RequestBody AppUser appUser){
        appUserService.addNewUser(appUser);
    }

    @PutMapping(path = "/update")
    public void updateUser(@RequestBody AppUser appUser){
        appUserService.updateUser(appUser);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUSer(@PathVariable("userId") Integer id){
    appUserService.deleteUser(id);
    }

    @PutMapping("/login")
    public String userLogin(@RequestBody AppUser appUser){
        return appUserService.loginUser(appUser);
    }



}
