package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.UserLoginDto;
import com.manhattan.models.dtos.UserRegisterDto;
import com.manhattan.models.entities.User;

public interface UserService {

    String registerUser(UserRegisterDto mode);

    String loginUser(UserLoginDto model);

    String logout();

    boolean isAdminLogged();

    User getCurrentUser();
}
