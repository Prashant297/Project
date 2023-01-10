package core_java_problem_solution.playerSkill_service;

import java.util.*;

public class Solution  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerServiceImpl playerService = new PlayerServiceImpl();
        List<Player> playerList = new ArrayList<>(playerService.addPlayerDetail());

        System.out.println("Enter Skill");
        String skill = scanner.next();
        System.out.println("Enter Level");
        String level = scanner.next();

        int points = PlayerServiceImpl.findPointsForGivenSkill(playerList, skill);
        Player player = PlayerServiceImpl.getPlayerBasedOnLevel(playerList, skill, level);

        if (points <= 0) {
            System.out.println("The given skill is not available");
        } else {
            System.out.println(points);
        }

        if (player != null) {
            System.out.println(player.playerId);
        } else {
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }
}
