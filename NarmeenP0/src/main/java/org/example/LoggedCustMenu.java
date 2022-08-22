package org.example;

import java.util.Scanner;

public class LoggedCustMenu {

    static ProjectDao dao = ProjectDaoFactory.getProjectDao();
    private static Scanner scanner = new Scanner(System.in);

    public static void loggedCustMenu(String email1, String password) {


        System.out.println("Please Select Banking Option from Below:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Balance");
        int input = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case 1: {

                System.out.println("Enter Amount you Want to Deposit Please:");
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    System.out.println(" Please Enter a Positive amount");
                }
                dao.deposit(email1, amount);
            }

        }


    }
}
