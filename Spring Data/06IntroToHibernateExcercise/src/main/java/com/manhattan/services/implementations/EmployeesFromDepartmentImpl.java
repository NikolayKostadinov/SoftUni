package com.manhattan.services.implementations;

import com.manhattan.models.EmployeeWithSallaryModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 5.	Employees from Department
 */
public class EmployeesFromDepartmentImpl extends BaseServiceImpl {

    public EmployeesFromDepartmentImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        //TODO: If JOIN clause was omitted there will be n+1 query problem!!!
        TypedQuery<EmployeeWithSallaryModel> query =
                this.entityManager.createQuery(
                        "SELECT NEW com.manhattan.models.EmployeeWithSallaryModel(e.firstName, e.lastName, d.name, e.salary) " +
                                "FROM Employee e JOIN e.department d " +
                                "WHERE d.name = :departmentName " +
                                "ORDER BY e.salary, e.id", EmployeeWithSallaryModel.class);

        String departmentName = "Research and Development";
        query.setParameter("departmentName", departmentName);

        List<EmployeeWithSallaryModel> employees = query.getResultList();

        String resultMessage =
                (employees.isEmpty()) ? "No results Found" :
                        employees.stream()
                                .map(EmployeeWithSallaryModel::toString)
                                .collect(Collectors.joining(System.lineSeparator()));

        printResultMessage(resultMessage);
    }
}
