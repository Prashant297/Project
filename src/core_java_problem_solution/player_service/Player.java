package core_java_problem_solution.player_service;

public class Player {
    int playerId;
    String name;
    int iccRank;
    int matchPlayed;
    int runsScored;

    public Player() {

    }

    public int getplayerId() {
        return playerId;
    }

    public void setplayerId(int playerId) {
        playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIccRank() {
        return iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

}
