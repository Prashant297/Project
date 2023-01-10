package core_java_problem_solution.flower_service;

import java.util.*;

public class FlowerServiceImpl implements FlowerService{
    @Override
    public List<Flower> addFlowerDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Flower> flowerList = new ArrayList<>();
        System.out.println("\u001B[31m Enter no. of Flower detail you want");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Flower flower = new Flower();
            System.out.println("Enter Flower Id");
            flower.setFlowerId(scanner.nextInt());
            System.out.println("Enter Flower Name");
            flower.setFlowerName(scanner.next());
            System.out.println("Enter Flower Price");
            flower.setPrice(scanner.nextInt());
            System.out.println("Enter Flower Rating");
            flower.setRating(scanner.nextInt());
            System.out.println("Enter Flower Type");
            flower.setType(scanner.next());
            flowerList.add(flower);
        }
        return flowerList;
    }
    static  int findMinPriceByType(List<Flower> flowerList,String  type){
        IntSummaryStatistics min = flowerList.stream()
                            .filter(flower -> flower.getType().equalsIgnoreCase(type))
                             .filter(flower -> flower.getRating()>=3)
                            .mapToInt(Flower::getPrice).summaryStatistics();

        int flowerId = flowerList.stream().filter(flower -> flower.getPrice() == min.getMin())
                       .findFirst().map(Flower::getFlowerId).orElse(0);
        return flowerId;
    }
}
