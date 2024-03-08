package com.martijn.CompCheck.service.appUser;

import com.martijn.CompCheck.dto.AppUserDto;
import com.martijn.CompCheck.model.AppUser;
import com.martijn.CompCheck.repository.AppUserRepository;
import com.martijn.CompCheck.service.tax.;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService{
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUserDto getUserById() {
        return null;
    }

    @Override
    public AppUserDto addNewUser() {
        return null;
    }

    @Override
    public AppUserDto updateUser() {
        return null;
    }

    @Override
    public void deleteUserById() {

    }

    public Optional<AppUser> getAppUserById(Integer id) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        if (optionalAppUser.isPresent()) {
            return optionalAppUser;
        }
        else {
            throw new IllegalStateException("User with ID:" + id + " doesn't exists");
        }
    }

    public void addNewUser(AppUser appUser) {
        appUser.setPassword(createHash(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    public void updateUser(AppUser appUser) {
        int userId = appUser.getId();
        Optional<AppUser> optionalAppUser = appUserRepository.findById(userId);
        if (optionalAppUser.isPresent()) {
            AppUser oldUser = optionalAppUser.get();

            if (!appUser.getFirstName().isEmpty() && appUser.getFirstName() !=null) {
                oldUser.setFirstName(appUser.getFirstName());
            }
            if (!appUser.getLastName().isEmpty() && appUser.getLastName() != null) {
                oldUser.setLastName(appUser.getLastName());
            }
            if (!appUser.getEmail().isEmpty() && appUser.getEmail() != null) {
                oldUser.setEmail(appUser.getEmail());
            }
            if (appUser.getDob() != null) {
                oldUser.setDob(appUser.getDob());
            }
            if (!appUser.getCity().isEmpty() && appUser.getCity() != null) {
                oldUser.setCity(appUser.getCity());
            }
            if (appUser.getYearsOfExperience() != null) {
                oldUser.setYearsOfExperience(appUser.getYearsOfExperience());
            }
            if (appUser.getSalaryYearly() != null) {
                oldUser.setSalaryYearly((appUser.getSalaryYearly()));
            }
            if (appUser.getCompanyId() != null) {
                oldUser.setCompanyId(appUser.getCompanyId());
            }
            if (!appUser.getPassword().isEmpty() && appUser.getPassword() != null) {
                oldUser.setPassword(createHash(appUser.getPassword()));
            }

            appUserRepository.save(oldUser);

        } else {
            throw new IllegalStateException("User with ID:" + appUser.getId() + " doesn't exists");
        }
    }

    public Boolean loginUser(String email, String password){
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmailEqualsIgnoreCase(email);

        if (optionalAppUser.isPresent()) {
            AppUser appUserToLogin = optionalAppUser.get();
            String hashOfPassword = createHash(password);

            if(hashOfPassword.equals(appUserToLogin.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            throw new IllegalStateException(String.format("Email doesn't exists!\nemail: %s \npassword: %s", email, password));
        }

    }

    public static String createHash(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();

            for (byte b : resultByteArray) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String findUserIdAsStringByEmail(String email){
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmailEqualsIgnoreCase(email);
        if (optionalAppUser.isPresent()) {
            AppUser appUserToLogin = optionalAppUser.get();
            return appUserToLogin.getId().toString();
        }
        else {
            throw new RuntimeException("user doesn't excist");
        }
    }

    public AppUser giveUserById(int id){
       Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
       if (optionalAppUser.isPresent()){
           return optionalAppUser.get();
       }
       else{
           throw new RuntimeException("No user found");
       }
    }
}