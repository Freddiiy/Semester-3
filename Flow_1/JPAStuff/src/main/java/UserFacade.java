import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.Queue;

public class UserFacade {
    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {}

    public static UserFacade getORMMapper(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new UserFacade();
            emf = _emf;
        }
        return instance;
    }

    public List<User> getNames() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<User> query = entityManager.createQuery("select user from User user", User.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public User getUserByName(String fname, String lname) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<User> query = entityManager.createQuery("select user from User user where user.fname =:_fname and user.lname =:_lname", User.class);
            query.setParameter("_fname", fname);
            query.setParameter("_lname", lname);
            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
        
    }
}
