package com.manhattan.services.implementations;

import com.manhattan.models.dtos.UserLoginDto;
import com.manhattan.models.dtos.UserRegisterDto;
import com.manhattan.models.entities.User;
import com.manhattan.repositories.UserRepository;
import com.manhattan.services.interfaces.UserService;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final ValidationsUtil validator;
    private User currentUser;

    public UserServiceImpl(UserRepository repository, ModelMapper modelMapper, ValidationsUtil validator) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.currentUser = null;
    }


    @Override
    public String registerUser(UserRegisterDto model) {
        this.validator.validateModel(model);
        validatePasswordsEquality(model);
        User user = this.modelMapper.map(model, User.class);
        makeUserAdminIfIsFirst(user);
        this.repository.saveAndFlush(user);
        return String.format("%s was registered", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDto model) {
        this.validator.validateModel(model);
        User user = this.repository.findOneByEmailAndPassword(model.getEmail(), model.getPassword()).
                orElseThrow(() -> new ValidationException(List.of(new ErrorMessage("Incorrect username / password"))));
        this.currentUser = user;
        return String.format("Successfully logged in %s", user.getFullName());
    }

    @Override
    public String logout() {
        if (this.currentUser == null){
            throw new ValidationException(List.of(new ErrorMessage("Cannot log out. No user was logged in.")));
        }
        String message = String.format("User %s successfully logged out", this.currentUser.getFullName());
        this.currentUser = null;
        return message;
    }


    private void makeUserAdminIfIsFirst(User user) {
        if (this.repository.count() == 0){
            user.setIsAdministrator(true);
        }
    }

    private void validatePasswordsEquality(UserRegisterDto model) {
        if (!model.getPassword().equals(model.getConfirmPassword())){
            throw new ValidationException(List.of(new ErrorMessage("Password and confirm password must be same")));
        }
    }
}
