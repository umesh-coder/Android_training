// Player.java
package Assignment_1;

public class Player {
    private String playerName;
    private String role;
    private Team team;
    private PlayerStats stats;

    public Player(String name, String role, Team team) {
        this.playerName = name;
        this.role = role;
        this.team = team;
        this.stats = new PlayerStats();
    }

    public void updateStats(int runs, int balls, int wickets) {
        stats.updateStats(runs, balls, wickets);
    }

    public String getPlayerName() { return playerName; }
    public String getRole() { return role; }
    public Team getTeam() { return team; }
    public PlayerStats getStats() { return stats; }
}
