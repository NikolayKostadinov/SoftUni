package com.manhattan;

import com.manhattan.services.interfaces.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApplication implements CommandLineRunner {
    private final EmployeeService service;

    public ConsoleApplication(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.service.findOne(1));
        System.out.println(this.service.findManagerOne(1));
    }
}
