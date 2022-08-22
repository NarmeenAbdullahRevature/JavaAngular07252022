package org.example;

import java.util.Scanner;

public class EmployeeMenu {

    static ProjectDao dao = ProjectDaoFactory.getProjectDao();

    private static final Scanner scanner = new Scanner(System.in);


    public static void employeeMenu(String email) {
        boolean flag = true;
        while (flag) {
            System.out.println("Options: \n ___________________________________________________________________");
            System.out.println("1.Approve a new account");
            System.out.println("2.View all accounts");
            System.out.println("3.View all pending accounts");
            System.out.println("4.View all approved accounts");


            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    System.out.println("Please enter the account email of the account you would like to approve: ");
                    String accountEmail = scanner.nextLine();
                    dao.approveAccount(accountEmail);
                    flag = false;
                case 2:
                    dao.viewAllAccounts();
                    break;
                case 3:
                    dao.viewAllPendingAccounts();
                    break;
                case 4:
                    dao.viewAllApprovedAccounts();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}