
package org.example;

import java.util.Scanner;

public class CheckingMenu {
    static ProjectDao dao = ProjectDaoFactory.getProjectDao();

    private static final Scanner scanner = new Scanner(System.in);

    public static void checkingMenu(String email) {

        boolean flag = true;
        while (flag) {
            System.out.println("options: \n ___________________________________________________________________");
            System.out.println("1. deposit into checking account");
            System.out.println("2. withdraw from checking account");
            System.out.println("3. view balance");
            System.out.println("4. logout");

            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Please enter the amount you would like to deposit: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    if (deposit > 0) {
                        dao.depositToChecking(email, deposit);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    flag = false;

                case 2:
                    System.out.println("Please enter the amount you would like to withdraw: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    if (withdraw > 0) {
                        dao.withdrawCheckingAccount(withdraw, email);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    flag = false;
                case 3:
                    dao.viewCheckingBalance(email);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }


        }

    }
}