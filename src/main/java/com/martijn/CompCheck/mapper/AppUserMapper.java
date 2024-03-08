package com.martijn.CompCheck.mapper;

import com.martijn.CompCheck.dto.AppUserDto;
import com.martijn.CompCheck.model.AppUser;

public class AppUserMapper {

    public static AppUserDto fromUserToDto(AppUser appUser) {
        return new AppUserDto(
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail(),
                appUser.getDob(),
                appUser.getCity(),
                appUser.getYearsOfExperience(),
                appUser.getSalaryYearly(),
                appUser.getCompanyId(),
                appUser.getPassword()
        );
    }

    public static AppUser userDtoToAppUser(AppUserDto appUserDto) {
        AppUser user = new AppUser();
        user.setFirstName(appUserDto.firstName());
        user.setLastName(appUserDto.lastName());
        user.setEmail(appUserDto.email());
        user.setDob(appUserDto.dob());
        user.setCity(appUserDto.city());
        user.setYearsOfExperience(appUserDto.yearsOfExperience());
        user.setCompanyId(appUserDto.companyId());
        user.setPassword(appUserDto.password());

        return user;
    }

}
