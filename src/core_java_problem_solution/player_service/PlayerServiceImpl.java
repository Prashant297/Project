package core_java_problem_solution.player_service;

import java.util.*;


public class PlayerServiceImpl implements PlayerService{
    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    @Override
    public List<Player> addPlayerDetail() {
        List<Player> playerList = new ArrayList<>();
        System.out.println("Enter no. of detail you want to enter");
        int num = scanner.nextInt();

        for (int i=0; i<num; i++){
            Player player = new Player();
            System.out.println("Enter Player Id");
            player.setplayerId(scanner.nextInt());
            System.out.println("Enter player Name");
            player.setName(scanner.next());
            System.out.println("Enter player ICC Rank");
            player.setIccRank(scanner.nextInt());
            System.out.println("Enter player Matched Played");
            player.setMatchPlayed(scanner.nextInt());
            System.out.println("Enter player run");
            player.setRunsScored(scanner.nextInt());
            playerList.add(player);
        }
        return playerList;
    }

    static List<Double> findAverageOfRuns(List<Player> playerList, int target){
        List<Double> averageOfRunsList = new ArrayList<>();
        for (Player player : playerList){
            if (player.getMatchPlayed()>=target){
                double average = player.getRunsScored()/player.getMatchPlayed();
                averageOfRunsList.add(average);
            }
        }

        return averageOfRunsList;
    }
}
