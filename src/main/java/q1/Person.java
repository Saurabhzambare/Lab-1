package q1;
import java.util.Objects;

/**
 * @author Saurabh Lalit Zambare
 * Date: 05/10/2022
 * This class contains atributes and methods for a Person object
 */

public class Person {

    //Enum
    public enum Gender { M, NOT_SPECIFIED, F }

    // class variables (static)
    protected static int COUNT;

    // instance variables (non-static)
    private String firstname;
    private String lastname;
    private String SIN;
    private Gender gender;


    //Constructors
    public Person() {
        COUNT++;
        this.firstname = "default";
        this.lastname = "default";
        this.SIN = "default";
        this.gender = Gender.NOT_SPECIFIED;
    }

    public Person(String firstname, String lastname) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(String firstname, String lastname, String SIN) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.SIN = SIN;
    }

    public Person(String firstname, String lastname,Gender gender, String SIN) throws Exception {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.SIN = SIN;
    }

    //firstname getters and setter
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //lastname getters and setter
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //gender getters and setter
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {return gender;}

    //SIN getters and setter
    public String getSIN() {
        return SIN;
    }
    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    //count getters
    public static int getCOUNT() {
        return COUNT;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", SIN='" + SIN + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        COUNT--;
        System.out.println(COUNT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(gender,person.gender) && Objects.equals(SIN, person.SIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, SIN, gender);
    }

}
