import entity.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Costumer hans = new Costumer("Hans", "Christian");
        Costumer anders = new Costumer("Anders", "Hansen");

        em.getTransaction().begin();
        em.persist(hans);
        em.persist(anders);
        em.getTransaction().commit();
        em.close();
        emf.close();

        Facade facade = new Facade();
        Costumer costumer = facade.findById(1);

        System.out.println(costumer.getFirstName() + " " + costumer.getLastName());

    }
}
