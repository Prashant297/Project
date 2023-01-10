package core_java_problem_solution.shirt_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShirtServiceImpl shirtService = new ShirtServiceImpl();
        List<Shirt> shirtList = new ArrayList<>(shirtService.addShirtList());
        System.out.println("Enter price");
        double price = scanner.nextDouble();
        List<Integer> discountPrice = new ArrayList<>(shirtService.getDiscountPrice(shirtList));
        discountPrice.forEach(System.out::println);

        List<Shirt> shirtList1 = new ArrayList<>(shirtService.getShirtWithMoreThanSpecificPrice(shirtList,price));
        for (Shirt shirt :shirtList1){
            System.out.println(shirt.getTag()+"  "+shirt.getPrice()+"  "+shirt.getBrand());
        }
    }
}
