package com.martijn.CompCheck.user;

import com.martijn.CompCheck.company.CompanyService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;


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
        appUser.setCompanyId(1); // functionality to create a new company isn't there yet

        appUserService.addNewUser(appUser);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new AppUser());
        return "login";
    }

    // TO DO
    @PutMapping( "/login")
    public String userLogin(@ModelAttribute("loginForm") AppUser appuser, Model model, HttpServletResponse response) {
        model.addAttribute("loginForm", new AppUser());
        boolean validLogin = appUserService.loginUser(appuser.getEmail(), appuser.getPassword());

        if (validLogin){
            String userID = appUserService.findUserIdAsStringByEmail(appuser.getEmail());
            Cookie cookie = new Cookie("userID", userID);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/index";
        }

        else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @CookieValue("userID") String id){
        AppUser appUser = appUserService.giveUserById(Integer.parseInt(id));
        model.addAttribute("appUser", appUser);
        return "profile";
    }

}
