package com.demo.pr_summary_demo.controller;

//package com.demo.prsummary.controller;

import com.demo.pr_summary_demo.dto.EmployeeRequest;
import com.demo.pr_summary_demo.dto.EmployeeResponse;
import com.demo.pr_summary_demo.model.Employee;
import com.demo.pr_summary_demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeResponse createEmployee(
            @RequestBody EmployeeRequest request) {

        return service.createEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable Integer id) {
            return service.getEmployee(id);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Employee API";
        }


     
}
