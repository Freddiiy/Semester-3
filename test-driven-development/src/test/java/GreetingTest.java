import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {
    private Greeting greeting;

    @BeforeEach
    void setUp() {
        greeting = new Greeting();
    }

    @AfterEach
    void tearDown() {
    }

    //Write a method greet(name) that interpolates name in a simple greeting.
    // For example, when name is "Bob", the method should return a string "Hello, Bob.".
    @Test
    void req1() {
        String name = "Bob";

        String actual = greeting.greet(name);
        String expected = "Hello, Bob.";

        assertEquals(expected, actual);
    }

    //Handle nulls by introducing a stand-in.
    // For example, when name is null, then the method should return the string "Hello, my friend."
    @Test
    void req2() {
        String name = null;

        String actual = greeting.greet(name);
        String expected = "Hello, my friend.";

        assertEquals(expected, actual);

    }

    //Handle shouting. When name is all uppercase, then the method should shout back to the user.
    // For example, when name is "JERRY" then the method should return the string "HELLO JERRY!"

    @Test
    void req3() {
        String name = "JERRY";

        String actual = greeting.greet(name);
        String expected = "HELLO JERRY!";

        assertEquals(expected, actual);
    }

    //Handle two names of input.
    // When name is an array of two names
    // (or, in languages that support it, varargs or a splat), then both names should be printed.
    //
    // For example, when name is ["Jill", "Jane"], then the method should return the string "Hello, Jill and Jane."

    @Test
    void req4() {
        String[] names = {"Jill", "Jane"};

        String actual = greeting.greet(names);
        String expected = "Hello, Jill and Jane.";

        assertEquals(expected, actual);
    }

    //Handle an arbitrary number of names as input.
    // When name represents more than two names, separate them with commas and close with an Oxford comma and "and".
    // For example, when name is ["Amy", "Brian", "Charlotte"],
    // then the method should return the string "Hello, Amy, Brian, and Charlotte."

    @Test
    void req5() {
        String[] names = {"Amy", "Brian", "Charlotte"};

        String actual = greeting.greet(names);
        String expected = "Hello, Amy, Brian, and Charlotte.";

        assertEquals(expected, actual);
    }

    //Allow mixing of normal and shouted names by separating the response into two greetings.
    //For example, when name is ["Amy", "BRIAN", "Charlotte"], then the method should return the string
    // "Hello, Amy and Charlotte. AND HELLO BRIAN!"

    @Test
    void req6() {
        String[] names = {"Amy", "BRIAN", "Charlotte"};

        String actual = greeting.greet(names);
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";

        assertEquals(expected, actual);
    }

    //If any entries in name are a string containing a comma, split it as its own input.
    //For example, when name is ["Bob", "Charlie, Dianne"], then the method should return the
    //string "Hello, Bob, Charlie, and Dianne.".

    @Test
    void req7() {
        String[] names = {"Bob", "Charlie, Dianne"};

        String actual = greeting.greet(names);
        String expected = "Hello, Bob, Charlie, and Dianne.";

        assertEquals(expected, actual);
    }

    //Allow the input to escape intentional commas introduced by Requirement 7.
    // These can be escaped in the same manner that CSV is, with double quotes surrounding the entry.
    // For example, when name is ["Bob", "\"Charlie, Dianne\""], then the method should return the
    // string "Hello, Bob and Charlie, Dianne.".

    @Test
    void req8() {
        String[] names = {"Bob", "\"Charlie, Dianne\""};

        String actual = greeting.greet(names);
        String expected = "Hello, Bob and Charlie, Dianne.";

        assertEquals(expected, actual);
    }


}