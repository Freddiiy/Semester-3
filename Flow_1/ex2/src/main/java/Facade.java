import entity.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade {

    private EntityManagerFactory _emf;

    private EntityManager init() {
        if (_emf == null) {
            _emf = Persistence.createEntityManagerFactory("pu");
        }
        return _emf.createEntityManager();
    }

    public Costumer findById(long id) {
        EntityManager em = init();
        return em.find(Costumer.class, id);
    }
}
