package com.demo.pr_summary_demo.dto;

//package com.demo.prsummary.dto;

public class EmployeeRequest {

    private String name;
    private String department;

    public EmployeeRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
