package q4;
import q1.Person;

/**
 * @author Saurabh Lalit Zambare
 * Date: 05/10/2022
 * This class creates car objects
 */

public class App {
    public void run(){
        try{
            //Person
            Person p1 = new Person("Saurabh", "Zambare",Person.Gender.M, "1234");
            Person p2 = new Person("Lalit", "Zambare", Person.Gender.M,"4567");
            Person p3 = new Person("Varun", "Zambare", Person.Gender.M,"6789");
            //Printing Person
            System.out.println("p1="+p1);
            System.out.println("p2="+p2);
            System.out.println("p3="+p3);

            //Car
            Car c1 = new Car("Ferrari", "Car1", 2010, 1234, p1);
            Car c2 = new Car("Ford", "Car2", 2011, 1234, p2);
            Car c3 = new Car("BMW", "Car2", 2012, 1234, p3);
            //Printing Car
            System.out.println("c1="+c1);
            System.out.println("c2="+c2);
            System.out.println("c3="+c3);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

