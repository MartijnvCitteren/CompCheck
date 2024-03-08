package com.martijn.CompCheck.controller;

import com.martijn.CompCheck.service.tax.TaxServices;
import com.martijn.CompCheck.service.appUser.AppUserServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/user")
public class AppUserController {
    private final AppUserServiceImpl appUserServiceImpl;

    @Autowired
    public AppUserController(AppUserServiceImpl appUserServiceImpl) {
        this.appUserServiceImpl = appUserServiceImpl;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationForm", new TaxServices.AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute TaxServices.AppUser appUser, Model model) {
        model.addAttribute("registrationForm", new TaxServices.AppUser());
        appUser.setCompanyId(1); // functionality to create a new company isn't there yet

        appUserServiceImpl.addNewUser(appUser);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new TaxServices.AppUser());
        return "login";
    }

    @PutMapping( "/login")
    public String userLogin(@ModelAttribute("loginForm") TaxServices.AppUser appuser, Model model, HttpServletResponse response) {
        model.addAttribute("loginForm", new TaxServices.AppUser());
        boolean validLogin = appUserServiceImpl.loginUser(appuser.getEmail(), appuser.getPassword());

        if (validLogin){
            String userID = appUserServiceImpl.findUserIdAsStringByEmail(appuser.getEmail());
            Cookie cookie = new Cookie("userID", userID);
            cookie.setPath("/");
            response.addCookie(cookie);
            System.out.println("Cookie" + cookie.toString());
            return "redirect:/index";
        }
        else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @CookieValue("userID") String id){
        TaxServices.AppUser appUser = appUserServiceImpl.giveUserById(Integer.parseInt(id));
        model.addAttribute("appUser", appUser);
        return "profile";
    }

    @GetMapping("/profile/update")
    public String update(Model model) {
        model.addAttribute("updateForm", new TaxServices.AppUser());
        return "update_profile";
    }
    @PostMapping("/profile/update")
    public String updateUser(@ModelAttribute("updateForm") TaxServices.AppUser appUser, Model model, @CookieValue("userID") String id) {
        model.addAttribute("updateForm", new TaxServices.AppUser());
        appUser.setId(Integer.parseInt(id));
        appUserServiceImpl.updateUser(appUser);
        return "redirect:/user/profile";
    }

    @GetMapping("/allusers")
    public String appUsers(Model model) {
        model.addAttribute("appUser", appUserServiceImpl.getAllUsers());
        return "users";
    }
}
