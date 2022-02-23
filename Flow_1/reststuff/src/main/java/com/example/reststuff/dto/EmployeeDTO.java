package com.example.reststuff.dto;

import com.example.reststuff.entity.Employee;

public class EmployeeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String jobtitle;

    public EmployeeDTO(Employee employee) {
        if (employee.getId() == null) {
            this.id = employee.getId();
            this.firstname = employee.getFirstname();
            this.lastname = employee.getLastname();
            this.jobtitle = employee.getJob();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }
}
