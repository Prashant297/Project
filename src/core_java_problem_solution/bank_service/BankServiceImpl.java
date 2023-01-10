package core_java_problem_solution.bank_service;

import java.util.*;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService{
    @Override
    public List<Bank> addBankDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Bank> bankList = new ArrayList<>();
        System.out.println("Enter no of bank detail you want");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Bank bank = new Bank();
            System.out.println("Enter Bank Id");
            bank.setBankId(scanner.nextInt());
            System.out.println("Enter Bank Name");
            bank.setBankName(scanner.next());
            System.out.println("Enter no. of customer");
            bank.setNoOfCustomer(scanner.nextInt());
            System.out.println("Enter city");
            bank.setCity(scanner.next());
            bankList.add(bank);
        }
        return bankList;
    }
    static int findAvgNumberOfCustomersByCity(List<Bank> bankList,String city){
        int sum = bankList.stream().filter(bank -> bank.getCity().equalsIgnoreCase(city))
                .mapToInt(Bank::getNoOfCustomer).sum();

        int count = (int) bankList.stream().filter(bank -> bank.getCity().equalsIgnoreCase(city)).count();

        sum = sum/count;
        return sum;
    }

    static Bank getSecondLowestNumberOfCustomersBank(List<Bank> bankList){
        Bank bank1 = null;
        List<Integer> list = bankList.stream().map(Bank::getNoOfCustomer).sorted().collect(Collectors.toList());
        if (list.size()==1){
            bank1 = bankList.stream().filter(bank -> bank.getNoOfCustomer() == list.get(0) && list.get(0) % 2 == 0)
                    .findFirst().orElse(null);
        }
        if (list.size()>1){
            bank1 = bankList.stream().filter(bank -> bank.getNoOfCustomer() == list.get(1) && list.get(1) % 2 == 0)
                    .findFirst().orElse(null);
        }
        return bank1;
    }
}
