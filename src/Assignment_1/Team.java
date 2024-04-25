// Team.java
package Assignment_1;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String homeGround;
    private List<Player> players;

    public Team(String name, String ground) {
        this.teamName = name;
        this.homeGround = ground;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getTeamName() { return teamName; }
    public String getHomeGround() { return homeGround; }
    public List<Player> getPlayers() { return players; }
    public int getTeamLength() { return players.size(); }
}
