package core_java_problem_solution.playerSkill_service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerServiceImpl implements PlayerService{

    @Override
    public List<Player> addPlayerDetail() {
        Scanner scanner = new Scanner(System.in );

        List<Player> playerList = new ArrayList<>();

        System.out.println("Enter no of Player Detail you want to enter");
        int num = scanner.nextInt();
        for (int i=0; i<num; i++){
            Player player = new Player();
            System.out.println("Enter Player Id");
            player.setPlayerId(scanner.nextInt());
            System.out.println("Enter Player Skill ");
            player.setSkill(scanner.next());
            System.out.println("Enter Player Level ");
            player.setLevel(scanner.next());
            System.out.println("Enter Player point");
            player.setPoint(scanner.nextInt());
            if(playerList.isEmpty()) {
                playerList.add(player);
            }
            if (!checkSkillAndLevelExits(playerList,player)){
                playerList.add(player);
            }
        }
        return playerList;
    }

    private boolean checkSkillAndLevelExits(List<Player> playerList,Player player) {
        AtomicBoolean exit = new AtomicBoolean(false);
        playerList.forEach(player1 -> {
            if (player1.getSkill().equalsIgnoreCase(player.getSkill()) && player1.getLevel().equalsIgnoreCase(player.getLevel())){
                exit.set(true);
            }
        });
        return exit.get();
    }

    static int findPointsForGivenSkill(List<Player> playerList, String skill){
        int points = 0;
            for (Player player : playerList){
                if(player.getSkill().equalsIgnoreCase(skill)){
                   points+=player.getPoint();
                }
            }
        return points;
    }

    static Player getPlayerBasedOnLevel(List<Player> playerList,String skill, String level){
        Player player = null;
        for (Player player1 : playerList){
            if (player1.getSkill().equalsIgnoreCase(skill) && player1.getLevel().equalsIgnoreCase(level)
                    && player1.getPoint()>=20){
                player=player1;
            }
        }
        return player;
    }
}
