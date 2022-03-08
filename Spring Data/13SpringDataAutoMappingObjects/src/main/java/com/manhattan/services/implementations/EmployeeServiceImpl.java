package com.manhattan.services.implementations;

import com.manhattan.configs.ModelMapperConfig;
import com.manhattan.dto.EmployeeDto;
import com.manhattan.dto.ManagerDto;
import com.manhattan.entities.Employee;
import com.manhattan.repositories.EmployeeRepository;
import com.manhattan.services.interfaces.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto findOne(int id) {
        return mapper
                .map(this.repository.findById(id).orElseThrow(),
                        EmployeeDto.class
                );
    }

    @Override
    public ManagerDto findManagerOne(int id) {
        return mapper
                .map(this.repository.findById(id).orElseThrow(),
                        ManagerDto.class
                );
    }
}
