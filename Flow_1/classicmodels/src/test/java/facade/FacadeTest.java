package facade;

import entity.EmployeesEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeTest {
    Facade facade;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createEmployeeTest() {
        EmployeesEntity employee = new EmployeesEntity();
        employee.setLastName("Busk");
        employee.setFirstName("Arnold");
        employee.setJobTitle("Programmer");
        employee.setEmail("arnoldsbusk@email.com");
        employee.setExtension("x9876");

        EmployeesEntity expected = new EmployeesEntity();
        EmployeesEntity actual = facade.createEmployee(employee);

        assertEquals(expected, actual);
    }

}