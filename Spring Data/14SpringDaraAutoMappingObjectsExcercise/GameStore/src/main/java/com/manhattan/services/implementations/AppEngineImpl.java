package com.manhattan.services.implementations;

import com.manhattan.models.dtos.GameAddDto;
import com.manhattan.models.dtos.UserLoginDto;
import com.manhattan.models.dtos.UserRegisterDto;
import com.manhattan.services.interfaces.AppEngine;
import com.manhattan.services.interfaces.ConsoleService;
import com.manhattan.services.interfaces.GameService;
import com.manhattan.services.interfaces.UserService;
import org.modelmapper.ValidationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
public class AppEngineImpl implements AppEngine {
    private final ConsoleService console;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public AppEngineImpl(ConsoleService console, UserService userService, GameService gameService) {
        this.console = console;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run() throws IOException {
        while (true) {
            try {
                String[] commands = console.readStringFromConsole("Enter your command: ").split("\\|");
                switch (commands[0]) {
                    case "RegisterUser" -> console.printInfoMessage(registerUser(commands));
                    case "LoginUser" -> console.printInfoMessage(loginUser(commands));
                    case "Logout" -> console.printInfoMessage(logout());
                    case "AddGame" -> console.printInfoMessage(addGame(commands));
                    default -> console.printErrorMessage("Invalid command!");
                }
            } catch (ValidationException ve) {
                printValidationException(ve);
            }
        }
    }

    private String addGame(String[] commands) {
        GameAddDto gameAddDto = new GameAddDto(commands[1],
                BigDecimal.valueOf(Double.parseDouble(commands[2])),
                BigDecimal.valueOf(Double.parseDouble(commands[3])),
                commands[4], commands[5], commands[6], commands[7]);

        return this.gameService.add(gameAddDto);
    }

    private String logout() {
        return this.userService.logout();
    }

    private String loginUser(String[] commands) {
        return this.userService.loginUser(new UserLoginDto(commands[1], commands[2]));
    }

    private String registerUser(String[] commands) {
        return this.userService.registerUser(
                new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
    }

    private void printValidationException(ValidationException ve) {
        this.console.printErrorMessage(
                ve.getErrorMessages()
                        .stream()
                        .map(ErrorMessage::getMessage)
                        .collect(Collectors.joining(System.lineSeparator())));
    }


}
