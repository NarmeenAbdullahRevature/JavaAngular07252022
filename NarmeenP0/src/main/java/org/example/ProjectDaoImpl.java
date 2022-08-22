package org.example;

import org.example.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjectDaoImpl implements ProjectDao {

    Connection connection;

    public ProjectDaoImpl() {

        connection = ConnectionFactory.getConnection();
    }


    @Override
    public void newCheckingAccount(String name, String email, String password, double deposit) {
        String sql = "INSERT INTO checkingAccount (custName, email, password, deposit) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setDouble(4, deposit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql2 = "update checkingAccount set balance = (deposit + balance) where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql3 = "update checkingAccount set deposit = 0 where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql3)) {
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void newSavingsAccount(String name, String email, String password, double deposit) {

    }

    @Override
    public void customerLogin(String email, String password) {

        boolean flag = true;
        while (flag) {
            System.out.println("1. log in to checking account");
            System.out.println("2. log in to savings account");
            System.out.println("3. exit");
            Scanner scanner = new Scanner(System.in);
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    String sql = "select * from checkingAccount where email = ? and password = ?";

                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, email);
                        statement.setString(2, password);
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            System.out.println("Welcome " + resultSet.getString("custName"));
                            System.out.println("Your balance is " + resultSet.getDouble("balance"));
                            CheckingMenu.checkingMenu(email);

                        } else {
                            System.out.println("Invalid login");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    flag = false;

                case 2:
                    String sql2 = "select * from savingAccount where email = ? and password = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql2)) {
                        statement.setString(1, email);
                        statement.setString(2, password);
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            System.out.println("Welcome " + resultSet.getString("custName"));
                            System.out.println("Your balance is " + resultSet.getDouble("balance"));
                        } else {
                            System.out.println("Invalid login");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using J Bank");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }}

    @Override
    public void employeeLogin(String email, String password) {
        //check if employee is in database
        String sql = "select * from employee where email = ? and password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Welcome " + resultSet.getString("Ename"));
                EmployeeMenu.employeeMenu(email);
            } else {
                System.out.println("Invalid login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exit() {
        System.out.println("Thank you for using J Bank");
        System.exit(0);
    }

    @Override
    public void viewSavingsBalance(String email) {
        String sql = "select * from savingAccount where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Your balance is " + resultSet.getDouble("balance"));
            } else {
                System.out.println("Invalid login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void viewCheckingBalance(String email) {
        String sql = "select * from checkingAccount where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Your balance is " + resultSet.getDouble("balance"));
            } else {
                System.out.println("Invalid login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void depositToSavings(String email, double deposit) {
        String sql = "update savingAccount set balance = (deposit + balance) where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void depositToChecking(String email, double deposit) {
        String sql = "update checkingAccount set balance = (checkingaccount.balance + ?) where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setDouble(2, deposit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void withdrawSavingsAccount(double withdraw, String email) {
        String sql = "update savingAccount set balance = (savingaccount.balance - ?) where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, withdraw);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void withdrawCheckingAccount(double withdraw, String email) {
        String sql = "update checkingAccount set balance = (checkingaccount.balance - ?) where email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, withdraw);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void approveAccount(String accountEmail) {
        System.out.println("1. approve checking account");
        System.out.println("2. approve savings account");
        System.out.println("3. exit");
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                String sql = "update checkingAccount set approved = 1 where email = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, accountEmail);
                    statement.executeUpdate();
                    System.out.println("Thank You, Account was Approved successfully");
                    approveAccount(accountEmail);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                String sql2 = "update savingAccount set approved = 1 where email = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql2)) {
                    statement.setString(1, accountEmail);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Thank you for using J Bank");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }


    @Override
    public void viewAllAccounts() {
        //join all tables to view all accounts
        String sql = "select * from checkingAccount join savingAccount on checkingAccount.email = savingAccount.email";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("custName"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Balance: " + resultSet.getDouble("balance"));
                System.out.println("Approved: " + resultSet.getBoolean("approved"));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }


    @Override
    public void viewAllPendingAccounts() {

        String sql = "select * from checkingAccount join savingAccount on checkingAccount.email = savingAccount.email where checkingAccount.approved = 0 or savingAccount.approved = 0";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("custName"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Balance: " + resultSet.getDouble("balance"));
                System.out.println("Approved: " + resultSet.getBoolean("approved"));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    @Override
    public void viewAllApprovedAccounts() {
        String sql = "select * from checkingAccount join savingAccount on checkingAccount.email = savingAccount.email where checkingAccount.approved = 1 and savingAccount.approved = 1";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("custName"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Balance: " + resultSet.getDouble("balance"));
                System.out.println("Approved: " + resultSet.getBoolean("approved"));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
