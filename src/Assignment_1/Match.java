// Match.java
package Assignment_1;

public class Match {
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void updateScores(int score1, int score2) {
        if (score1 > Constants.MAX_SCORE || score2 > Constants.MAX_SCORE) {
            throw new IllegalArgumentException("Match score cannot exceed " + Constants.MAX_SCORE);
        }
        team1Score = score1;
        team2Score = score2;
    }

    public Team getTeam1() { return team1; }
    public Team getTeam2() { return team2; }
    public int getTeam1Score() { return team1Score; }
    public int getTeam2Score() { return team2Score; }
}
