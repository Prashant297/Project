package core_java_problem_solution.customer_account;

public class Customer {
    String name;
    int accountNo;
    int balance;
    int savingAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public int getSavingAccount() {
        return savingAccount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setSavingAccount(int savingAccount) {
        this.savingAccount = savingAccount;
    }
}
