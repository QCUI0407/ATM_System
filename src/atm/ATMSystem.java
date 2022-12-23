package atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * ATM system 
 */
public class ATMSystem {
    public static void main(String[] args) {
        // 2.create array list,Store account objects and perform operations
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 3.System Home page
        while (true) {

            System.out.println("===================ATM SYSTEM===================");
            System.out.println("1.Login");
            System.out.println("2.Register Account");

            System.out.println("Please choose a number: ");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    // login
                    login(accounts, sc);
                    break;
                case 2:
                    // open account
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("Command Error");
            }
        }
    }
    /*
     * login function
     * 
     * @param accounts --------all account obj array
     * 
     * @param sc ---------Scanner
     */

    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("===================LOGIN===================");
        // 1.check is there an account in the array
        if (accounts.size() == 0) {
            System.out.println("Empty array, no account available");
            return; // return to --- System Home page
        }

        // 2. login
        while (true) {

            System.out.println("Please enter your card id: ");
            String cardId = sc.next();

            // 3.search card bu id
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc != null) {
                //keep try pw untill pw is correct
                while (true) {
                    // card ifno find
                    // 4. enter PW
                    System.out.println("Please enter the password: ");
                    String password = sc.next();
                    // Verify the password
                    if (acc.getPassWord().equals(password)) {
                        // true, success
                        System.out.println("Welcome " + acc.getUserName() + "ID: " + acc.getCardId());
                    } else {
                        System.out.println("Password is wrong!!!");
                    }
                }
            } else {
                System.out.println("can not find " + cardId + " in the system");
            }
        }

    }

    /*
     * Registered Account Function
     * 
     * @param accounts----------- receive account arr
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("===================Account opening interface===================");
        // 1. create array list,Store account objects and perform operations
        Account account = new Account();

        // 2.Store account info
        System.out.println("Enter new username: ");
        String userName = sc.next();
        account.setUserName(userName);

        while (true) {
        System.out.println("Enter password: ");
        String passWord = sc.next();
        System.out.println("Confirm password: ");
        String confirmPassWord = sc.next();
            if (confirmPassWord.equals(passWord)) {
                // pw comfirm same
                account.setPassWord(confirmPassWord);
                break; // Successfully created password, stop loop
            } else {
                System.out.println("Password enter not same");
            }
        }

        System.out.println("Enter withdrawal amount: ");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);

        /* Random unique 8-digit account number （建议独立功能， 独立成方法） */
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        // 3.add to account arr list
        accounts.add(account);
        System.out.println("congratulations " + userName + ". Your Card number/ID is: " + cardId);

    }

    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            // 1. generate 8 digits number
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }

            // 2.Check card number is duplicated
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                // if its null, mean this number available to use， return to use
                return cardId;
            }
            return null;
        }
    }

    /*
     * search account info by id
     * 
     * @param cardId --- card number
     * 
     * @param account --- all account array
     * 
     * @return account info | if do not have return null
     */
    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;// no info for this card ID
    }
}