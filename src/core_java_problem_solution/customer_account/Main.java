package core_java_problem_solution.customer_account;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        List<Customer> currentAccountList = new ArrayList<>(customerService.addCustomerDetail());
        final List<Customer> savingAccountList = new ArrayList<>();
        int n=1;
        while (n==1) {
            System.out.println("\nEnter \n1.Open Saving A/c\n2.Add balance\n3.Withdraw\n4.Customer Detail");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    savingAccountList.addAll(customerService.addSavingAccount(currentAccountList));
                    break;
                case 2:
                    customerService.addBalance(currentAccountList);
                    break;
                case 3:
                    customerService.withdrawCash(currentAccountList);
                    break;
                case 4:
                    customerService.showCustomerDetail(currentAccountList,savingAccountList);
                    break;
                default:
                    break;
            }
            System.out.println("\nDo you want to continue\n1.Yes\n2.No");
            n = scanner.nextInt();
        }
    }
}
