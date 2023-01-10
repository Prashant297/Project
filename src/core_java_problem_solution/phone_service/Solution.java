package core_java_problem_solution.phone_service;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        List<Phone> phoneList = new ArrayList<>(phoneService.addPhoneDetail());
        System.out.println("Enter Brand Name");
        String brand = scanner.next();
        System.out.println("Enter os");
        String os = scanner.next();

        int priceList = PhoneServiceImpl.findPriceForGivenBrand(phoneList,brand);
        if (priceList ==0) {
            System.out.println("The given brand is not available");
        }else {
                System.out.println(priceList);
            }

     Phone getOs = PhoneServiceImpl.getPhoneIdBasedOnOs(phoneList,os);
        if (getOs==null){
            System.out.println("No phones are available with specified os and price range");
        }else
            System.out.println(getOs.getPhoneId());
        }
    }

