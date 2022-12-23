package atm;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ATM system 
 */
public class ATMSystem {
    public static void main(String[] args) {
        // 2.create array list,Store account objects and perform operations
        ArrayList<Account> accounts = new ArrayList<>();

        // 3.System Home page
        while (true) {

            System.out.println("===================ATM SYSTEM===================");
            System.out.println("1.Login");
            System.out.println("2.Register Account");

            Scanner sc = new Scanner(System.in);
            System.out.println("Please choose a number: ");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    // login
                    break;
                case 2:
                    // open account
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
}