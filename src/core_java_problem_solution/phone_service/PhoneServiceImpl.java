package core_java_problem_solution.phone_service;

import java.util.*;

public class PhoneServiceImpl implements PhoneService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public List<Phone> addPhoneDetail() {
        final List<Phone> phoneList = new ArrayList<>();

        System.out.println("Enter NO. of Phone detail you want");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            Phone phone = new Phone();
            System.out.println("Enter phone Id");
            phone.setPhoneId(scanner.nextInt());
            System.out.println("Enter phone os");
            phone.setOs(checkOsExitsInPhoneList(scanner.next(),phoneList));
            System.out.println("Enter Phone Brand");
            phone.setBrand(scanner.next());
            System.out.println("Enter Phone Price");
            phone.setPrice(checkPhonePrice(scanner.nextInt()));

            phoneList.add(phone);
        }
        return phoneList;
    }

    private int checkPhonePrice(int price) {
        while (true) {
            if (price > 0) break;
            System.out.println("Please Enter Price value more than 0");
            price = scanner.nextInt();
            }
        return price;
    }

    private String checkOsExitsInPhoneList(String os, List<Phone> phoneList) {
        if (phoneList.isEmpty()) {
            return os;
        }
        List<String> osList = new ArrayList<>();
        phoneList.forEach(phone1 -> osList.add(phone1.getOs()));
        String ops = os;
        if (phoneList.isEmpty()) return os;
        while (true) {
            if (!osList.contains(ops)) return ops;
            else {
                System.out.println("Please Enter Os because it already exits");
                ops = scanner.next();
            }
        }
    }

    static int findPriceForGivenBrand(List<Phone> phoneList, String brand) {
        int price=0;
        for (Phone value : phoneList) {
            if (value.getBrand().equalsIgnoreCase(brand)) {
                price+=value.getPrice();
            }
        }
        return price;
    }

    static Phone getPhoneIdBasedOnOs(List<Phone> phoneList, String os) {
        Phone phone=null;
        for (Phone phone1 : phoneList) {
            if (phone1.getOs().equalsIgnoreCase(os) && phone1.getPrice() >= 50000) {
                phone=phone1;
            }
        }
        return phone;
    }
}
