package core_java_problem_solution.sim_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        SimServiceImpl simService = new SimServiceImpl();
        List<Sim> simList = new ArrayList<>(simService.addSimDetail());

        System.out.println("Enter circle you want to change");
        String oldCircle = scanner.next();
        System.out.println("Enter new Circle");
        String newCircle = scanner.next();

        List<Sim> updatedSimList = new ArrayList<>(SimServiceImpl.transferCustomerCircle(simList,oldCircle,newCircle));
        if (!updatedSimList.isEmpty()){
            for (Sim sim : updatedSimList){
                System.out.println(sim.getSimId()+"  "+sim.getCustomerName()+"  "+sim.getCircle()+"  "+sim.getRatePerSecond());
            }
        }
    }
}
