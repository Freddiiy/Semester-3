package facades;

import com.fredoku.point.entities.Child;
import com.fredoku.point.entities.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void create(Parent parent){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        em.persist(parent);
        parent.getChildren().forEach(child -> {
            if (child.getId() == null) {
                em.persist(child);
            }
            if (em.find(Child.class, child.getId()) == null) {
                em.persist(child);
            }
        });
        em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        Parent parent = new Parent("Helga", 23);
        EntityManager em  = emf.createEntityManager();
        TypedQuery<Child> query = em.createQuery("select c from Child c where c.name =:name", Child.class);
        query.setParameter("name", "Ole");

        List<Child> children = query.getResultList();
        parent.addChildren(children.get(0));
        facade.create(parent);

    }
}
