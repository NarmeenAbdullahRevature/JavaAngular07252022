package org.example;

public interface ProjectDao {
    void newCheckingAccount(String name, String email, String password, double deposit);
    void newSavingsAccount(String name, String email, String password, double deposit);
    void customerLogin(String email, String password);
    void employeeLogin(String email, String password);
    void exit();

    void viewSavingsBalance(String email);
    void viewCheckingBalance(String email);

    void depositToSavings(String email, double deposit);
    void depositToChecking(String email, double deposit);

    void withdrawSavingsAccount(double withdraw, String email);
    void withdrawCheckingAccount(double withdraw, String email);

    void approveAccount(String accountEmail);

    void viewAllAccounts();

    void viewAllPendingAccounts();

    void viewAllApprovedAccounts();
}
