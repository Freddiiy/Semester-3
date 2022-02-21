package com.example.reststuff.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Generate
{

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();

            Customer c1 = new Customer("steve","taylor", "Java developer");
            Customer c2 = new Customer("Michelle","schmidt", "Not working");
            Customer c3 = new Customer("Marc","johan", "Eating stuff");
            Customer c4 = new Customer("jorg","oertel", "Typescript lover");

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Employee e1 = new Employee("Steve", "Hartman", "programmer");
            Employee e2 = new Employee("Carl", "Handsome", "consultant");
            Employee e3 = new Employee("Lola", "Kirstensen", "fashion designer");
            Employee e4 = new Employee("Abemand", "Orangotang", "monkey");

            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            em.persist(e4);

            em.getTransaction().commit();
        }
        finally {
            em.close();
            emf.close();
        }
    }

}