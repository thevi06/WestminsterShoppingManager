import java.io.IOException;
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