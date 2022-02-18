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
        }
        finally {
            em.close();
            emf.close();
        }
    }

}