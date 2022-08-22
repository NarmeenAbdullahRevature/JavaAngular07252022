package org.example;

import org.example.ProjectDao;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Welcome to J Bank");

        ProjectDao dao = ProjectDaoFactory.getProjectDao();
        Scanner scanner = new Scanner(System.in);


        boolean flag = true;
        while (flag) {


            System.out.println("Please Select from the following banking options: \n ___________________________________________________________________");
            System.out.println("1. Apply for a New Checking Account");
            System.out.println("2. Apply for a New Savings Account");
            System.out.println("3. Customer Login");
            System.out.println("4. Employee Login");
            System.out.println("5. Exit \n ___________________________________________________________________");

            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    System.out.println("Please enter your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your email: ");
                    String email = scanner.nextLine();
                    System.out.println("Please enter your password: ");
                    String password = scanner.nextLine();
                    System.out.println("Please enter your deposit: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    dao.newCheckingAccount(name, email, password, deposit);
                    break;
                case 2:
                    System.out.println("Please enter your name: ");
                    name = scanner.nextLine();
                    System.out.println("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Please enter your password: ");
                    password = scanner.nextLine();
                    System.out.println("Please enter your deposit: ");
                    deposit = Double.parseDouble(scanner.nextLine());
                    dao.newSavingsAccount(name, email, password, deposit);
                    break;
                case 3:
                    System.out.println("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Please enter your password: ");
                    password = scanner.nextLine();
                    dao.customerLogin(email, password);
                    break;
                case 4:
                    System.out.println("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Please enter your password: ");
                    password = scanner.nextLine();
                    dao.employeeLogin(email, password);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }


        }


    }
}