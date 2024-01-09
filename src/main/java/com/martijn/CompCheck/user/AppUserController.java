package com.martijn.CompCheck.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    //Thymeleaf controllers
    @GetMapping("/allusers")
    public String appUsers(Model model) {
        model.addAttribute("appUser", appUserService.getAllUsers());
        return "users";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationForm", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute AppUser appUser, Model model) {
        model.addAttribute("registrationForm", new AppUser());
        appUserService.addNewUser(appUser);
        return "users";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new AppUser());
        return "login";
    }

    // TO DO
    @PutMapping("/login")
    public String userLogin(@ModelAttribute AppUser appUser, Model model) {
        model.addAttribute("loginForm");
        return appUserService.loginUser(appUser);
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
    public String registerNewUser(@RequestBody AppUser appUser){
        appUserService.addNewUser(appUser);
        return "users";
    }

    @PutMapping(path = "/update")
    public void updateUser(@RequestBody AppUser appUser){
        appUserService.updateUser(appUser);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUSer(@PathVariable("userId") Integer id){
    appUserService.deleteUser(id);
    }

//    @PutMapping("/login")
//    public String userLogin(@RequestBody AppUser appUser){
//        return appUserService.loginUser(appUser);
//    }



}
