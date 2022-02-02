import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {
    private Greeting greeting;

    @BeforeEach
    void setUp() {
        greeting = new Greeting();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void helloTest() {
        MyClass instance = new MyClass();
        String actual = instance.hello();
        String expected = "Hello";

        assertEquals(actual, expected);
    }
}