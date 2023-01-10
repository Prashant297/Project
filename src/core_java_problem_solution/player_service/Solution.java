package core_java_problem_solution.player_service;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerServiceImpl playerService = new PlayerServiceImpl();
        List<Player> playerList = new ArrayList<>(playerService.addPlayerDetail());

        System.out.println("Enter Target");
        int target = scanner.nextInt();
        List<Double> averageOfRunsList = new ArrayList<>(PlayerServiceImpl.findAverageOfRuns(playerList,target));

        for (double average : averageOfRunsList){
            if(average>=80){
                System.out.println("Grade A");
            }else if (average>=50 && average<= 79){
                System.out.println("Grade B");
            }else {
                System.out.println("Grade C");
            }
        }
    }
}
