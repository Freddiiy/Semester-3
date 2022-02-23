package facade;

import entity.EmployeesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EmployeesEntity createEmployee(EmployeesEntity employee) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return employee;
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        EmployeesEntity employee = new EmployeesEntity();
        employee.setLastName("Busk");
        employee.setFirstName("Arnold");
        employee.setJobTitle("Programmer");
        employee.setEmail("arnoldsbusk@email.com");
        employee.setExtension("x9876");

        System.out.println(facade.createEmployee(employee).getFirstName());

    }
}
