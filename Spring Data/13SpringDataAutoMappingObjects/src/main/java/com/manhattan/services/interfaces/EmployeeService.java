package com.manhattan.services.interfaces;

import com.manhattan.dto.EmployeeDto;
import com.manhattan.dto.ManagerDto;

public interface EmployeeService {
    EmployeeDto findOne(int id);

    ManagerDto findManagerOne(int id);
}
