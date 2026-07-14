package com.demo.pr_summary_demo.repository;

//package com.demo.prsummary.repository;

import com.demo.pr_summary_demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Optional<Employee> findById(Integer id) {
        return employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();
    }
}
