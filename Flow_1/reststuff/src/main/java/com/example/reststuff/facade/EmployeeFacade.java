package com.example.reststuff.facade;

import com.example.reststuff.dto.CustomerDTO;
import com.example.reststuff.dto.EmployeeDTO;
import com.example.reststuff.entity.Customer;
import com.example.reststuff.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EmployeeDTO getEmployeeById(long id) {
        EntityManager em = emf.createEntityManager();
        Employee e = em.find(Employee.class, id);
        return new EmployeeDTO(e);
    }

}
