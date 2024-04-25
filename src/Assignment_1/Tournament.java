// Tournament.java
package Assignment_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {
    private List<Team> teams;
    private List<Match> matches;

    public Tournament() {
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(Team team) { teams.add(team); }
    public void addMatch(Match match) { matches.add(match); }

    public Player getHighestWicketTaker() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .max(Comparator.comparingInt(player -> player.getStats().getWicketsTaken()))
                .orElse(null);
    }

    public Player getPlayerWithMost50s() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .max(Comparator.comparingInt(player -> player.getStats().getRunsScored() / 50))
                .orElse(null);
    }

    public Player getPlayerWithHighestStrikeRate() {
        return teams.stream()
                .flatMap(team -> team.getPlayers().stream())
                .max(Comparator.comparingDouble(player -> player.getStats().getStrikeRate()))
                .orElse(null);
    }

    public List<Team> getTeams() { return teams; }
    public List<Match> getMatches() { return matches; }
}
