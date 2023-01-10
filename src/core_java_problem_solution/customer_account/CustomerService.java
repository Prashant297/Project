package core_java_problem_solution.customer_account;

import java.util.List;

public interface CustomerService {
    List<Customer> addCustomerDetail();

    List<Customer> addSavingAccount(List<Customer>customerList);

    void addBalance(List<Customer>customerList);

    void withdrawCash(List<Customer>customerList);

    void showCustomerDetail(List<Customer> customerList,List<Customer> savingAccountList);
}
