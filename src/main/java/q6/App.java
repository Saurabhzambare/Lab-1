package q6;
import q1.Person;
import q4.Car;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Saurabh Lalit Zambare
 * Date: 05/10/2022
 */

public class App {
    private final int NUMCARS = 100;
    private final Car[] unsoldCars = new Car[NUMCARS];
    private final Car[] soldCars = new Car[NUMCARS];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private Scanner input = new Scanner(System.in);

    public void run(){

        boolean done=false;
        while (!done) {
            String menu = """
                    ----------------
                     1. Add a Car
                     2. Edit a car
                     3. Delete an unsold Car
                     4. Delete a sold Car
                     5. List unsold Cars
                     6. List sold Cars
                     7. Sell a Car
                    99. Exit
                    """;
            System.out.println("" + menu);
            try {
                int selection = input.nextInt();

                switch (selection) {
                    case 1 -> add();
                    case 2 -> {
                        listUnsoldCars();
                        edit();
                    }
                    case 3 -> {
                        System.out.println("Which car would you like to delete ?:");
                        int choice = input.nextInt();
                        input = new Scanner(System.in); // reset the scanner
                        deleteUnsoldCars(choice);
                    }
                    case 4 -> deleteSoldCars();
                    case 5 -> listUnsoldCars();
                    case 6 -> listSoldCars();
                    case 7 -> {
                        listUnsoldCars();
                        System.out.println("Which car would you like to sell ?:");
                        int chosenCar = input.nextInt();
                        input = new Scanner(System.in); // reset the scanner
                        sellCar(chosenCar);
                    }
                    case 99 -> done = true;
                    default -> System.out.println("You chose incorrectly");
                }
            } catch (InputMismatchException e) {
                System.out.println("You entered an incorrect option, please try again.");
            } catch(UnsupportedOperationException e){
                System.out.println("Unsupported operation.");
            }
        }
        System.exit(0);
    }

    //String Input
    private String getInput(String s) {
        String userInput = input.nextLine();
        if (userInput.trim().isEmpty()) {
            return s;
        }
        Scanner userInput2 = new Scanner(userInput);
        return userInput2.nextLine();
    }

    //Int Input
    private int getInput(int i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner userInput2 = new Scanner(s);
        return userInput2.nextInt();
    }

    //Double Input
    private double getInput(double i) {
        String s = input.nextLine();
        if (s.trim().isEmpty()) {
            return i;
        }
        Scanner userInput2 = new Scanner(s);
        return userInput2.nextDouble();
    }

    //add New car in the list
    private void add() {
        Car car = new Car();
        input = new Scanner(System.in); // reset the scanner

        System.out.println("Enter the make of Car: ");
        car.setMake(getInput(car.getMake()));
        System.out.println("Enter the model of Car: ");
        car.setModel(getInput(car.getModel()));
        System.out.println("Enter the year of Car: ");
        car.setYear(getInput(car.getYear()));
        unsoldCars[unsoldCurrentIndex] = car;
        unsoldCurrentIndex++;
    }

    //edit car from list of unsold car
    private void edit() {
        while(true){
            try{
                System.out.println("Which car would you like to edit ?: ");
                int select = input.nextInt();
                input = new Scanner(System.in); // reset the scanner

                if ((select < unsoldCurrentIndex + 1) && select > 0) {
                    Car car = unsoldCars[select - 1];
                    //make
                    System.out.println("Make: " + car.getMake());
                    car.setMake(getInput(car.getMake()));
                    //model
                    System.out.println("Model: " + car.getModel());
                    car.setModel(getInput(car.getModel()));
                    //year
                    System.out.println("Year: " + car.getYear());
                    car.setYear(getInput(car.getYear()));
                } else {
                    System.out.println("Choice out of bounds");
                }
                break;

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    //Printing the list of Unsold car from car list
    private void listUnsoldCars() {
        System.out.println("--------------------");
        System.out.println("List of unsold cars");
        System.out.println("--------------------");
        for(int i = 0; i < unsoldCars.length; i++){
            Car car = unsoldCars[i];
            if(car == null){
                break;
            }else{
                System.out.println( (i+1)+". Make: "+car.getMake() + " Model: " + car.getModel()+ " Year: " + car.getYear());
            }
        }
    }

    //delete car from Unsold car list
    private void deleteUnsoldCars(int select){
        if((select < unsoldCars.length && select > 0)){
            if (unsoldCars.length - 1 - (select - 1) >= 0)
                System.arraycopy(unsoldCars, select - 1 + 1, unsoldCars, select - 1, unsoldCars.length - 1 - (select - 1));
            unsoldCars[unsoldCars.length - 1] = null;
        }else{
            System.out.println("Choice out of bounds");
        }
        unsoldCurrentIndex--;
    }
    //delete car from sold car list
    private void deleteSoldCars(){
        System.out.println("Which car would you like to delete ?:");
        int select = input.nextInt();
        input = new Scanner(System.in); // reset the scanner
        if((select < soldCars.length && select >0)){
            if (soldCars.length - 1 - (select - 1) >= 0)
                System.arraycopy(soldCars, select - 1 + 1, soldCars, select - 1, soldCars.length - 1 - (select - 1));
            soldCars[soldCars.length - 1] = null;

        }else{
            System.out.println("Choice out of bounds");
        }
        soldCurrentIndex--;
    }


    //Printing the list of sold car from car list
    private void listSoldCars() {
        System.out.println("---------------------");
        System.out.println("List of sold cars");
        System.out.println("---------------------");
        for(int i = 0; i < soldCars.length; i++){
            Car car = soldCars[i];
            if(car == null){
                break;
            }else{
                System.out.println( (i+1)+". Make: "+car.getMake() + " Model: " + car.getModel()+ " Year: " + car.getYear());
            }
        }
    }

    //sell a car form unsoldCars list
    private void sellCar(int chosenCar){
        var newOwner = new Person();

        if((chosenCar < unsoldCars.length && chosenCar >0)){
            var car = unsoldCars[chosenCar-1];

            System.out.println("Enter Owner's first name: ");
            newOwner.setFirstname(getInput(newOwner.getFirstname()));
            System.out.println("Enter Owner's last name: ");
            newOwner.setLastname(getInput(newOwner.getLastname()));
            car.setOwner(newOwner);
            soldCars[soldCurrentIndex]=car;
            soldCurrentIndex++;
            deleteUnsoldCars(chosenCar);

        }else{
            System.out.println("Choice out of bounds");
        }
    }
}


