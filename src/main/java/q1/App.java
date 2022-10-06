package q1;

public class App {
    public void run() {
        try{
            //Person
            Person p1 = new Person("Saurabh", "Zambare",Person.Gender.M, "1234");
            Person p2 = new Person("Lalit", "Zambare", Person.Gender.M,"4567");
            Person p3 = new Person("Varun", "Zambare", Person.Gender.M,"6789");
            //Printing Person
            System.out.println("p1="+p1);
            System.out.println("p2="+p2);
            System.out.println("p3="+p3);
            System.out.println(Person.getCOUNT());
            System.gc();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
