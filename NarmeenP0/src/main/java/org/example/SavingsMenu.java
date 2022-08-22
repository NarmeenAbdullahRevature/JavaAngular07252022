
package org.example;

import java.util.Scanner;

public class SavingsMenu {
    static ProjectDao dao = ProjectDaoFactory.getProjectDao();

    private static final Scanner scanner = new Scanner(System.in);

    public static void savingsMenu(String email) {

        boolean flag = true;

        while (flag) {
            System.out.println("options: \n ___________________________________________________________________");
            System.out.println("1. deposit into savings account");
            System.out.println("2. withdraw from savings account");
            System.out.println("3. view balance");
            System.out.println("4. logout");

            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    System.out.println("Please enter your deposit: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    if (deposit > 0) {
                        dao.depositToSavings(email, deposit);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    flag = false;
                case 2:
                    System.out.println("Please enter your withdraw amount: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    if (withdraw > 0) {
                        dao.withdrawSavingsAccount(withdraw, email);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    flag = false;
                case 3:
                    dao.viewSavingsBalance(email);
                    break;
                case 4:
                    System.out.println("Thank you for using J Bank");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }


    }
}