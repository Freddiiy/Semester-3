import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserFacadeTest {
    UserFacade userFacade;
    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        System.out.println("TESTINGGGG");
        User user = new User();
        user.setFname("Hans");
        user.setLname("Hansen");
        user.setPassword("Hemmelig123");
        user.setPhone("40404040");
        user.setAddress("Rolighedsvej 3");

        emf = Persistence.createEntityManagerFactory("default");
        userFacade = UserFacade.getORMMapper(emf);

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        TypedQuery<User> query = em.createQuery("delete from User user", User.class);

        int deletedCount = query.executeUpdate();
        em.getTransaction().commit();
        System.out.println(deletedCount + " line(s) deleted");
        em.close();

    }

    @Test
    void getNames() {
        List<User> actual = userFacade.getNames();
        List<User> expected = new ArrayList<>();
        expected.add(new User("Hans", "Hansen"));

        assertEquals(expected.equals(actual), actual.equals(expected));
    }

    @Test
    void getDetails() {
        String[] expected = {"40404040", "Rolighedsvej 3"};
        String[] actual = userFacade.getUserByName("Hans", "Hansen").getDetails();

        assertEquals(Arrays.equals(expected, actual), Arrays.equals(actual, expected));
    }

    @Test
    void changeDetails() {

    }
}