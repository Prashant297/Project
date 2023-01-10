package core_java_problem_solution.shirt_service;

import java.util.*;
import java.util.stream.Collectors;

public class ShirtServiceImpl implements ShirtService {
    @Override
    public List<Shirt> addShirtList() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Shirt> shirtList = new ArrayList<>();
        System.out.println("Enter no. of Shirt detail you want");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Shirt shirt = new Shirt();
            System.out.println("Enter Shirt  tag");
            shirt.setTag(scanner.nextInt());
            System.out.println("Enter Shirt Brand");
            shirt.setBrand(scanner.next());
            System.out.println("Enter Shirt Price");
            shirt.setPrice(scanner.nextDouble());
            System.out.println("Enter Customer Gender");
            shirt.setGender(scanner.next());
            shirtList.add(shirt);
        }

        return shirtList;
    }

    static List<Integer> getDiscountPrice(List<Shirt>shirtList){
        List<Integer> discountPrice = new ArrayList<>();
        double discount;
        double totalDiscount=0;
         for (Shirt shirt: shirtList){
             if (shirt.getGender().equalsIgnoreCase("m")){
                 discount = shirt.getPrice()*0.9;
                 totalDiscount += shirt.getPrice()*0.1;
                 discountPrice.add((int) discount);
             }else if (shirt.getGender().equalsIgnoreCase("f")){
                 discount = shirt.getPrice()*0.8;
                 totalDiscount += shirt.getPrice()*0.2;
                 discountPrice.add((int) discount);
             }else if (shirt.getGender().equalsIgnoreCase("u")){
                 discount = shirt.getPrice()*0.7;
                 totalDiscount += shirt.getPrice()*0.3;
                 discountPrice.add((int) discount);
             }
         }
        System.out.println("Total Discount Given "+totalDiscount);
            return discountPrice;
    }

    static List<Shirt> getShirtWithMoreThanSpecificPrice(List<Shirt> shirtList,double price){
        List<Shirt> shirtList1 = shirtList.stream()
                                .filter(shirt1 -> shirt1.getPrice() > price)
                                .collect(Collectors.toList());
        return shirtList1;
    }
}
