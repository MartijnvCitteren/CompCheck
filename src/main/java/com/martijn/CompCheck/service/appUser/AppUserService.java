package com.martijn.CompCheck.service.appUser;

import com.martijn.CompCheck.dto.AppUserDto;

import java.util.List;

public interface AppUserService {

    List<AppUserDto> getAllUsers();
    AppUserDto getUserById();
    AppUserDto addNewUser();
    AppUserDto updateUser();
    void deleteUserById();
}
