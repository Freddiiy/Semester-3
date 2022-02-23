package com.example.reststuff.facade;

import com.example.reststuff.dto.CustomerDTO;
import com.example.reststuff.entity.Customer;
import com.example.reststuff.entity.Employee;

import javax.persistence.*;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public CustomerDTO getCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class, id);
        return new CustomerDTO(c);
    }

    public void addCustomer(CustomerDTO c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addEmplyee(Long customerId, Employee employee) {
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, customerId);

        try {
            if (customer == null) throw new NotFoundException();

            customer.addEmployee(employee);
            em.getTransaction().begin();

            em.merge(customer);
            em.getTransaction().commit();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            customerDTOList.add(new CustomerDTO(query.getResultList().get(i)));
        }
        return customerDTOList;
    }

    public void removeCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, id);
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomersByEmployeeId(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("select c from Customer c where Employee.id=:id", Customer.class);
            em.setProperty("id", id);

            return CustomerDTO.getDTOs(query.getResultList());
        } finally {
            em.close();
        }

    }
}
