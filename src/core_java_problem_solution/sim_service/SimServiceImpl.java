package core_java_problem_solution.sim_service;

import java.util.*;

import static java.util.Comparator.comparingDouble;


public class SimServiceImpl implements SimService {
    @Override
    public List<Sim> addSimDetail() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        List<Sim> simList = new ArrayList<>();

        System.out.println("Enter number of sim detail you want");
        int num = scanner.nextInt();

        for (int i=0; i<num; i++){

            Sim sim = new Sim();
            System.out.println("Enter Sim Id");
            sim.setSimId(scanner.nextInt());
            System.out.println("Enter Sim Customer Name");
            sim.setCustomerName(scanner.next());
            System.out.println("Enter Balance");
            sim.setBalance(scanner.nextDouble());
            System.out.println("Enter rate per second");
            sim.setRatePerSecond(scanner.nextDouble());
            System.out.println("Enter circle");
            sim.setCircle(scanner.next());
            simList.add(sim);
        }
        return simList;
    }

    static List<Sim> transferCustomerCircle(List<Sim> simList ,String oldCircle,String newCircle){
        List<Sim> updatedSimList = new ArrayList<>();
        for (Sim sim : simList){
            if (sim.getCircle().equals(oldCircle)){
                sim.setCircle(newCircle);
                updatedSimList.add(sim);
            }
        }
        updatedSimList.sort(comparingDouble(Sim::getRatePerSecond).reversed());
        return updatedSimList;
    }
}
