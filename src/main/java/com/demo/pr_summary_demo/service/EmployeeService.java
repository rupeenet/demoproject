package com.demo.pr_summary_demo.service;


import com.demo.pr_summary_demo.dto.EmployeeRequest;
import com.demo.pr_summary_demo.dto.EmployeeResponse;
import com.demo.pr_summary_demo.exception.EmployeeNotFoundException;
import com.demo.pr_summary_demo.model.Employee;
import com.demo.pr_summary_demo.repository.EmployeeRepository;
import com.demo.pr_summary_demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Employee employee = new Employee(
                idGenerator.getAndIncrement(),
                request.getName(),
                request.getDepartment());

        repository.save(employee);

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getDepartment());
    }

    public List<EmployeeResponse> getAllEmployees() {

        return repository.findAll()
                .stream()
                .map(emp -> new EmployeeResponse(
                        emp.getId(),
                        emp.getName(),
                        emp.getDepartment()))
                .collect(Collectors.toList());
    }

    public EmployeeResponse getEmployee(Integer id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException());

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getDepartment());
    }
}
