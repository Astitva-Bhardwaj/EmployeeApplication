package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        // Implement logic to generate unique ID and save employee
        employee.setId(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        // Implement logic to retrieve all employees
        return employeeRepository.findAll();
    }

    public void deleteEmployee(String id) {
        // Implement logic to delete an employee by ID
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        // Implement logic to update an employee by ID
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }

    public Employee getNthLevelManager(String employeeId, int level) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            System.out.println("## Service -- getNthLevelManager -- null");
            // Handle case where employee with given id is not found
            return null;
        }
        System.out.println("## Service -- getNthLevelManager -- not null");
        System.out.println("## getNthLevelManager -- final Employee value -- " + employee.toString());
        return getNthLevelManagerRecursive(employee, level);
    }

    private Employee getNthLevelManagerRecursive(Employee employee, int level) {
        System.out.println("## getNthLevelManagerRecursive");
        if (level <= 0 || employee.getReportsTo() == null) {
            System.out.println("## it should come here for level = 1");
            return employee;
        }
        System.out.println("## getNthLevelManagerRecursive -- employee" + employee.toString());
        return getNthLevelManagerRecursive(
                employeeRepository.findById(employee.getReportsTo()).orElse(null),
                level - 1
        );
    }

    public List<Employee> getAllEmployeesWithPaginationAndSorting(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        return employeePage.getContent();
    }

}

