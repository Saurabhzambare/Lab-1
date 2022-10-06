package q4;
import org.junit.jupiter.api.Test;
import q1.Person;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Saurabh Lalit Zambare
 * Date: 05/10/2022
 * This is a test for the Equals method from Car class
 */

class CarTest {
    @Test
    void testEquals() throws Exception {
        //Person
        Person p1 = new Person("Saurabh", "Zambare",Person.Gender.M, "1234");
        Person p2 = new Person("Lalit", "Zambare", Person.Gender.M,"4567");
        Person p3 = new Person("Saurabh", "Zambare", Person.Gender.M,"1234");

        assertEquals(p1, p3, "Both people must be equal");
        assertNotEquals(p1, p2, "Both people must NOT be equal");

        //Car
        Car c1 = new Car("Ferrari", "Car1", 2010, 1234, p1);
        Car c2 = new Car("Ford", "Car2", 2011, 1234, p2);
        Car c3 = new Car("Ferrari", "Car1", 2010, 1234, p1);

        assertEquals(c1, c3, "Both cars must be equal");
        assertNotEquals(c1, c2, "Both cars must NOT be equal");
    }
}