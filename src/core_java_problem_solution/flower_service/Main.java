package core_java_problem_solution.flower_service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        List<Flower> flowerList = new ArrayList<>(flowerService.addFlowerDetail());
        System.out.println("\u001B[32m Enter Flower Type");
        String type = scanner.next();

        int flowerId = flowerService.findMinPriceByType(flowerList,type);
        if (flowerId>0){
            System.out.println("\u001B[33m"+flowerId);
        }else {
            System.out.println("There is no flower with given type");
        }
    }
}
