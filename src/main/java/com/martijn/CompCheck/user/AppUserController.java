package com.martijn.CompCheck.user;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/user")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
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

    @PutMapping( "/login")
    public String userLogin(@ModelAttribute("loginForm") AppUser appuser, Model model, HttpServletResponse response) {
        model.addAttribute("loginForm", new AppUser());
        boolean validLogin = appUserService.loginUser(appuser.getEmail(), appuser.getPassword());

        if (validLogin){
            String userID = appUserService.findUserIdAsStringByEmail(appuser.getEmail());
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
        AppUser appUser = appUserService.giveUserById(Integer.parseInt(id));
        model.addAttribute("appUser", appUser);
        return "profile";
    }

    @GetMapping("/profile/update")
    public String update(Model model) {
        model.addAttribute("updateForm", new AppUser());
        return "update_profile";
    }
    @PostMapping("/profile/update")
    public String updateUser(@ModelAttribute("updateForm") AppUser appUser, Model model, @CookieValue("userID") String id) {
        model.addAttribute("updateForm", new AppUser());
        appUser.setId(Integer.parseInt(id));
        appUserService.updateUser(appUser);
        return "redirect:/user/profile";
    }

    @GetMapping("/allusers")
    public String appUsers(Model model) {
        model.addAttribute("appUser", appUserService.getAllUsers());
        return "users";
    }
}
