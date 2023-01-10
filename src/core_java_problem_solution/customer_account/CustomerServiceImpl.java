package core_java_problem_solution.customer_account;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    final Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    private  int count =0;


    @Override
    public List<Customer> addCustomerDetail() {
        List<Customer> customerList = new ArrayList<>();
        System.out.println("Enter no of Customer you want to add");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            Customer customer = new Customer();
            System.out.println("Enter Customer Name");
            customer.setName(scanner.next());
            System.out.println("Enter Customer Account No");
            customer.setAccountNo(scanner.nextInt());
            System.out.println("Enter Customer Balance");
            customer.setBalance(checkBalanceAmount(scanner.nextInt()));
            customerList.add(customer);
        }
        return customerList;
    }

    private int checkBalanceAmount(int balanceAmount) {
        int newBal=balanceAmount;
        while (newBal<=0){
            System.out.println("Balance should be greater than 0");
            System.out.println("Please Enter Balance");
            newBal = scanner.nextInt();
            if (newBal>0){
                return newBal;
            }
        }
        return newBal;
    }

    @Override
    public List<Customer> addSavingAccount(List<Customer> customerList) {
        final List<Customer> savingList = new ArrayList<>();
        System.out.println("Enter Account Number");
        int accountNumber = scanner.nextInt();
        for (Customer customer : customerList) {
            if (customer.getAccountNo()==accountNumber) {
                Customer customer1 = new Customer();
                customer1.setName(customer.getName());
                customer1.setSavingAccount(customer.getAccountNo());
                System.out.println("Enter Balance in saving account");
                customer1.setBalance(scanner.nextInt());
                savingList.add(customer1);
            }
        }
        return savingList;
    }

    @Override
    public void addBalance(List<Customer> customerList) {
        System.out.println("Enter Account Number");
        int accountNumber = scanner.nextInt();
        int addBalance;
        for (Customer customer : customerList) {
            if (customer.getAccountNo() == accountNumber) {
                System.out.println("Enter Balance you want to add");
                addBalance = scanner.nextInt();
                if (addBalance > 0) {
                    customer.setBalance(addBalance + customer.getBalance());
                } else System.out.println("Amount Should be greater than 0");
                count=1;
            }
        }
        if (count==0){
            System.out.println("Incorrect Account Number");
        }
    }

    @Override
    public void withdrawCash(List<Customer> customerList) {
        System.out.println("Enter Account Number");
        int accountNumber = scanner.nextInt();
        int amount;
        int amt;
        for (Customer customer : customerList) {
            if (customer.getAccountNo() == accountNumber) {
                System.out.println("Current Balance " + customer.getBalance());
                System.out.println("Enter the amount you want to withdraw");
                amount = scanner.nextInt();
                amt = customer.getBalance() - amount;
                if (amt<=5000 && amt>0) {
                    System.out.println("The minimum balance should be  5000 After Withdrawal");
                }else if (amount < customer.getBalance()) {
                    customer.setBalance(customer.getBalance() - amount);
                    System.out.println(" Amount of "+ amount+" has been withdraw ");
                } else {
                    System.out.println("You don't have Sufficient Balance");
                }
                count = 1;
            }
        }
        if (count==0){
            System.out.println("Incorrect Account Number");
        }
    }

    @Override
    public void showCustomerDetail(List<Customer> currentAccountList, List<Customer> savingAccountList) {
        int n = 1;
        while (n==1) {
            System.out.println("Enter \n1.Show All Customer Detail\n2.Detail by Account No");
            int opt = scanner.nextInt();
            if (opt == 1) {
                showAllCustomerDetail(currentAccountList, savingAccountList);
            } else if (opt == 2) {
                showDetailOnBasisOfAccountNo(currentAccountList, savingAccountList);
            }
            System.out.println("\nenter\n1.continue\n2.exit");
            n = scanner.nextInt();
        }
    }

    private void showDetailOnBasisOfAccountNo(List<Customer> currentAccountList, List<Customer> savingAccountList) {
        System.out.println("Enter Account Number");
        int accountNumber = scanner.nextInt();

        for (Customer customer : currentAccountList) {
            if (customer.getAccountNo() == accountNumber) {
                System.out.printf("%15s\t %10s %15s", "Customer Name", "Account No", "Balance\n");
                System.out.format("%10s %10d %20d", customer.getName(), customer.getAccountNo(), customer.getBalance());
                System.out.println();
                count = 1;
            }
        }
        if (count==0){
            System.out.println("Incorrect Account Number");
        }
        if (!savingAccountList.isEmpty()) {
            for (Customer customer1 : savingAccountList) {
                System.out.println("\nSaving Account Detail\n");
                if (customer1.getSavingAccount() == accountNumber) {
                    System.out.printf("%15s\t %10s %15s", "Customer Name", "Account No", "Balance\n");
                    System.out.format("%10s %10d %20d", customer1.getName(), customer1.getSavingAccount(), customer1.getBalance());
                    System.out.println();
                }
            }
        }
    }

    private void showAllCustomerDetail(List<Customer> currentAccountList, List<Customer> savingAccountList) {
        System.out.printf("%15s\t %10s %15s", "Customer Name", "Account No", "Balance\n");
        for (Customer customer : currentAccountList) {
            System.out.format("%10s %10d %20d", customer.getName(), customer.getAccountNo(), customer.getBalance());
            System.out.println();
        }
        if (!savingAccountList.isEmpty()) {
            System.out.println("\nSaving Account Detail\n");
            System.out.printf("%15s\t %10s %15s", "Customer Name", "Account No", "Balance\n");
            for (Customer customer1 : savingAccountList) {
                System.out.format("%10s %10d %20d", customer1.getName(), customer1.getAccountNo(), customer1.getBalance());
                System.out.println();
            }
        }
    }
}
