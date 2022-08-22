
public class SavingAccount {

    private int accnumber;
    private double balance;
    private String custName;
    private String email;
    private String pass;

    public SavingAccount(int accnumber, double balance, String custName, String email, String pass) {
        this.accnumber = accnumber;
        this.balance = balance;
        this.custName = custName;
        this.email = email;
        this.pass = pass;
    }

    public int getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(int accnumber) {
        this.accnumber = accnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "accnumber=" + accnumber +
                ", balance=" + balance +
                ", custName='" + custName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}