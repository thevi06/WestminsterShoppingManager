import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    static ShoppingManager manager = new WestminsterShoppingManager();
    final static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        menuloop:
        while (true) {
            try {
                displayMenu();
                int choice = scn.nextInt();
                //TODO: Validate the user input for integer

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        deleteProduct();
                        break;
                    case 3:
                        manager.printProduct();
                        break;
                    case 4:
                        manager.saveData();
                        break;
                    case 5:
                        manager.loadData();
                        break;
                    case 6:
                        ShoppingGUI g1 = new ShoppingGUI((WestminsterShoppingManager) manager);
                        break;
                    case 7:
                        System.out.println("Thank you for using the system");
                        break menuloop;
                    default:
                        System.out.println("invalid option");
                }
            }catch (InputMismatchException e){
                System.out.println("invalid input type");
                scn.next();  // Clear the scanner buffer

            }
        }

    }

    public static void displayMenu(){
        System.out.println("\n ----WELCOME TO WESTMINSTER ONLINE SHOPPING  CENTER-----");
        System.out.println("1: Add a new product");
        System.out.println("2: Delete a product");
        System.out.println("3: Display all products");
        System.out.println("4: Save Data");
        System.out.println("5: Load Data");
        System.out.println("6: Display GUI");
        System.out.println("7: Quite application");
    }

    //add product method
    public static void addProduct(){

        try{
            System.out.println("what do you want to add?");
            System.out.println("1.Electronics\n2.Clothing");
            String x= scn.next();

            if(x.equals("1")||x.equals("2")) {

                System.out.println("Enter product ID");
                String pId;
                do {
                    pId = scn.next();
    }