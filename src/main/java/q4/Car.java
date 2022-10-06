package q4;
import q1.Person;
import java.util.Objects;

/**
 * @author Saurabh Lalit Zambare
 * Date: 05/10/2022
 * This class contains atributes and methods
 */

public class Car {
    //class variable
    private static int COUNT;

    //instance variables
    private String Make;
    private String Model;
    private int  Year;

    private int VIN;
    private Person Owner;

    //Constructors

    public Car(){
        COUNT++;
        this.Make = "default";
        this.Model = "default";
        this.Year = 0;
        this.Owner = new Person();
        this.VIN = 0;
    }
    public Car(String make) {
        this();
        this.Make = make;
    }

    public Car(String make, String model, int year) {
        this();
        this.Make = make;
        this.Model = model;
        this.Year = year;
    }

    public Car(String make, String model, int year, Person owner) {
        this();
        this.Make = make;
        this.Model = model;
        this.Year = year;
        this.Owner = owner;
    }

    public Car(String make, String model, int year, int vin, Person owner) {
        this();
        this.Make = make;
        this.Model = model;
        this.Year = year;
        this.VIN = vin;
        this.Owner = owner;
    }
    //count getters
    public static int getCOUNT() {
        return COUNT;
    }

    //Make getters and setters
    public String getMake() {
        return Make;
    }
    public void setMake(String make) {
        this.Make = make;
    }

    //Model getters and setters
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        this.Model = model;
    }

    //Year getters and setters
    public int getYear() {
        return Year;
    }
    public void setYear(int year) {
        this.Year = year;
    }

    //VIN getters and setters
    public int getVIN() {
        return VIN;
    }
    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    //Owner getters and setters
    public Person getOwner() {
        return Owner;
    }
    public void setOwner(Person owner) {
        this.Owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", Year=" + Year +
                ", VIN=" + VIN +
                ", Owner=" + Owner.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(Make, car.Make) && Objects.equals(Model, car.Model) && Objects.equals(Year,car.Year) && Objects.equals(VIN, car.VIN)&& Objects.equals(Owner, car.Owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Make, Model, Year, VIN, Owner);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        COUNT--;
        System.out.println(COUNT);
    }
}
