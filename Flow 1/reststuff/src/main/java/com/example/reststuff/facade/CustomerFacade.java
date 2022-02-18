package com.example.reststuff.facade;

import com.example.reststuff.dto.CustomerDTO;
import com.example.reststuff.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
}
