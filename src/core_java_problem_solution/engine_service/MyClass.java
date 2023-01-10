package core_java_problem_solution.engine_service;


import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        EngineServiceImpl engineService = new EngineServiceImpl();
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Engine> engineMap = new LinkedHashMap<>(engineService.addEngine());
        if(!engineMap.isEmpty()) {

            System.out.println("Enter Engine Type");
            String type = scanner.next();
            System.out.println("Enter Engine Name");
            String name = scanner.next();
            double avgPrice = EngineServiceImpl.findAvgEnginePriceByType(type, engineMap);

            if (avgPrice > 0) System.out.println(avgPrice);
            else System.out.println("There are no engine with given type");

            List<Integer> idList = new ArrayList<>(EngineServiceImpl.searchEngineByName(name,engineMap));

            if (idList.isEmpty()) System.out.println("There are no Engine with the given name");
            else System.out.println(idList);

        }

    }
}
