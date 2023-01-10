package core_java_problem_solution.bank_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        BankServiceImpl bankService = new BankServiceImpl();
        List<Bank> bankList = new ArrayList<>(bankService.addBankDetail());
        System.out.println("Please Enter city ");
        String city = scanner.next();

        int average = bankService.findAvgNumberOfCustomersByCity(bankList,city);
        if (average>0){
            System.out.println(average);
        }else {
            System.out.println("Bank not Found");
        }

        Bank bank = bankService.getSecondLowestNumberOfCustomersBank(bankList);
        if (bank!=null){
            System.out.println(bank.getBankId()+"\n"+bank.getBankName()+"\n"+bank.getNoOfCustomer()+"\n"+bank.getCity());
        }else {
            System.out.println("Bank not Found");
        }


    }
}
