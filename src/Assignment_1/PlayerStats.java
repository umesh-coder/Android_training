// PlayerStats.java
package Assignment_1;

public class PlayerStats {
    private int runsScored;
    private int ballsFaced;
    private int wicketsTaken;
    private int matchesPlayed;

    public void updateStats(int runs, int balls, int wickets) {
        runsScored += runs;
        ballsFaced += balls;
        wicketsTaken += wickets;
        matchesPlayed++;
    }

    public int getRunsScored() { return runsScored; }
    public int getBallsFaced() { return ballsFaced; }
    public int getWicketsTaken() { return wicketsTaken; }
    public int getMatchesPlayed() { return matchesPlayed; }

    public double getStrikeRate() {
        if (ballsFaced == 0) return 0;
        return ((double) runsScored / ballsFaced) * 100;
    }
}
