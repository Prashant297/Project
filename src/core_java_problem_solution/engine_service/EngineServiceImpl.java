package core_java_problem_solution.engine_service;

import java.util.*;

public class EngineServiceImpl implements EngineService {
    Scanner scanner = new Scanner(System.in);


    @Override
    public Map<Integer, Engine> addEngine() {

        final Map<Integer, Engine> engineMap = new LinkedHashMap<>();
        System.out.println("Enter number of Engine object you want ");
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++) {
            Engine engine = new Engine();
            System.out.println("Enter Engine Id");
            engine.setEngineId(scanner.nextInt());
            System.out.println("Enter Engine Name");
            engine.setEngineName(scanner.next());
            System.out.println("Enter Engine Type");
            engine.setEngineType(scanner.next());
            System.out.println("Enter Engine Price");
            engine.setEnginePrice(scanner.nextInt());

            if (!engineMap.containsKey(engine.getEngineId())) {
                engineMap.put(engine.getEngineId(), engine);
            }
        }
        return engineMap;
    }

    static double findAvgEnginePriceByType(String type, Map<Integer, Engine> engineMap) {
        double totalPrice = 0;
        double count = 1;
        double avgPrice = 0;
        for (Map.Entry<Integer, Engine> engineEntry : engineMap.entrySet()) {
            Engine engine = engineEntry.getValue();
            if (engine.getEngineType().equals(type)) {
                totalPrice = totalPrice + engine.getEnginePrice();
                avgPrice = totalPrice / count;
                count++;
            }
        }
        return avgPrice;
    }

    static List<Integer> searchEngineByName(String name, Map<Integer, Engine> engineMap) {
        List<Integer> idList = new ArrayList<>();
        for (Map.Entry<Integer, Engine> engineEntry : engineMap.entrySet()) {
            Engine engine = engineEntry.getValue();
            if (engine.getEngineName().equals(name)) {
                idList.add(engineEntry.getKey());
            }
        }
        return idList;
    }
}
