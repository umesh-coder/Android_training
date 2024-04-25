//package Assignment_1;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//// Class to represent player statistics
//class PlayerStats {
//    private int runsScored;
//    private int ballsFaced;
//    private int wicketsTaken;
//    private int matchesPlayed;
//   
//
//    // Method to update player stats after each match
//    public void updateStats(int runs, int balls, int wickets) {
//        runsScored += runs;
//        ballsFaced += balls;
//        wicketsTaken += wickets;
//        matchesPlayed++;
//    }
//
//    // Getters for player statistics
//    public int getRunsScored() { return runsScored; }
//    public int getBallsFaced() { return ballsFaced; }
//    public int getWicketsTaken() { return wicketsTaken; }
//    public int getMatchesPlayed() { return matchesPlayed; }
//
//    // Calculate and return the strike rate of the player
//    public double getStrikeRate() {
//        if (ballsFaced == 0) return 0;
//        return ((double) runsScored / ballsFaced) * 100;
//    }
//}
//
//// Class to represent a player
//class Player {
//    private String playerName;
//    private String role;
//    private Team team;
//    private PlayerStats stats;
//
//    // Constructor to initialize a player
//    public Player(String name, String role, Team team) {
//        this.playerName = name;
//        this.role = role;
//        this.team = team;
//        this.stats = new PlayerStats();
//    }
//
//    // Method to update player statistics
//    public void updateStats(int runs, int balls, int wickets) {
//        stats.updateStats(runs, balls, wickets);
//    }
//
//    // Getters for playerName, role, team, and stats
//    public String getPlayerName() { return playerName; }
//    public String getRole() { return role; }
//    public Team getTeam() { return team; }
//    public PlayerStats getStats() { return stats; }
//}
//
//// Class to represent a team
//class Team {
//    private String teamName;
//    private String homeGround;
//    private List<Player> players;
//
//    // Constructor to initialize a team
//    public Team(String name, String ground) {
//        this.teamName = name;
//        this.homeGround = ground;
//        this.players = new ArrayList<>();
//        
//   
//    }
//
//    
//   
//    // Method to add a player to the team
//    public void addPlayer(Player player) {
//    	
//        players.add(player);
//        
//       
//    }
//
//    
//    // Getters for teamName, homeGround, and players
//    public String getTeamName() { return teamName; }
//    public String getHomeGround() { return homeGround; }
//    public List<Player> getPlayers() { return players; }
//    public int getteamlength() {return players.size(); }
//}
//
//// Class to represent a match
//class Match {
//    private Team team1;
//    private Team team2;
//    private int team1Score;
//    private int team2Score;
//    private final int MAX_SCORE = 300; // Maximum allowed score
//
//    // Constructor to initialize a match
//    public Match(Team team1, Team team2) {
//        this.team1 = team1;
//        this.team2 = team2;
//    }
//
//    // Method to update match scores with validation
//    public void updateScores(int score1, int score2) {
//        // Check if scores exceed the maximum allowed score
//        if (score1 > MAX_SCORE || score2 > MAX_SCORE) {
//            throw new IllegalArgumentException("Match score cannot exceed " + MAX_SCORE);
//        }
//        team1Score = score1;
//        team2Score = score2;
//    }
//
//    // Getters for teams, scores, and players
//    public Team getTeam1() { return team1; }
//    public Team getTeam2() { return team2; }
//    public int getTeam1Score() { return team1Score; }
//    public int getTeam2Score() { return team2Score; }
//}
//
//// Class to represent a tournament
//class Tournament {
//    private List<Team> teams;
//    private List<Match> matches;
//
//    // Constructor to initialize a tournament
//    public Tournament() {
//        this.teams = new ArrayList<>();
//        this.matches = new ArrayList<>();
//    }
//
//    // Method to add a team to the tournament
//    public void addTeam(Team team) { teams.add(team); }
//
//    // Method to add a match to the tournament
//    public void addMatch(Match match) { matches.add(match); }
//
//    // Method to get the player with the highest number of wickets
//    public Player getHighestWicketTaker() {
//        return teams.stream()
//                .flatMap(team -> team.getPlayers().stream()) // Flatten the list of players
//                .max(Comparator.comparingInt(player -> player.getStats().getWicketsTaken())) // Find the player with max wickets
//                .orElse(null); // Return null if no player found
//        
//    }
//
//    // Method to get the player with the most 50s
//    public Player getPlayerWithMost50s() {
//        return teams.stream()
//                .flatMap(team -> team.getPlayers().stream()) // Flatten the list of players
//                .max(Comparator.comparingInt(player -> player.getStats().getRunsScored() / 50)) // Find the player with max 50s
//                .orElse(null); // Return null if no player found
//    }
//    
//    
// // Method to get the player with the highest strike rate
//    public Player getPlayerWithHighestStrikeRate() {
//        return teams.stream()
//                .flatMap(team -> team.getPlayers().stream()) // Flatten the list of players
//                .max(Comparator.comparingDouble(player -> player.getStats().getStrikeRate())) // Find the player with max strike rate
//                .orElse(null); // Return null if no player found
//    }
//
//    // Getters for teams and matches
//    public List<Team> getTeams() { return teams; }
//    public List<Match> getMatches() { return matches; }
//}
//
//// Class to handle queries
//class QueryHandler {
//    // Method to handle different queries
//    public static Player handleQuery(String query, Tournament tournament) {
//    	
//        switch (query.toLowerCase()) {
//            case "who is the highest wicket taker of all time?":
//                return tournament.getHighestWicketTaker();
//            case "who has scored maximum numbers of 50s?":
//                return tournament.getPlayerWithMost50s();
//            case "who has higest strike rate?":
//            	return tournament.getPlayerWithHighestStrikeRate();
//            default:
//                return null;
//        }
//    }
//}
//
//// Main class to manage the IPL tournament
//public class IPLTournamentManager {
//    public static void main(String[] args) {
//        // Hardcoded data
//    	
//    	//create Team
//        Team team1 = new Team("CSK", "Ground A");
//        Team team2 = new Team("MI", "Ground B");
//
//        //added player in Team
//        Player player1 = new Player("M.S Dhoni", "Wicketkeeper", team1);
//        Player player2 = new Player("Ravindra Jadeja", "All-rounder", team1);
//        Player player3 = new Player("Suresh Raina", "Batsman", team1);
//        Player player4 = new Player("Ambati Rayudu", "Batsman", team1);
//        Player player5 = new Player("Faf du Plessis", "Batsman", team1);
//        Player player6 = new Player("Shane Watson", "All-rounder", team1);
//        Player player7 = new Player("Imran Tahir", "Bowler", team1);
//        Player player8 = new Player("Deepak Chahar", "Bowler", team1);
//        Player player9 = new Player("Sam Curran", "All-rounder", team1);
//        Player player10 = new Player("Lungi Ngidi", "Bowler", team1);
//        Player player11 = new Player("Murali Vijay", "Batsman", team1);
//        Player player12 = new Player("Kedar Jadhav", "All-rounder", team1);
//
//        team1.addPlayer(player1);
//        team1.addPlayer(player2);
//        team1.addPlayer(player3);
//        team1.addPlayer(player4);
//        team1.addPlayer(player5);
//        team1.addPlayer(player6);
//        team1.addPlayer(player7);
//        team1.addPlayer(player8);
//        team1.addPlayer(player9);
//        team1.addPlayer(player10);
//        team1.addPlayer(player11);
//        team1.addPlayer(player12);
//        
//        
//        //added player in Team
//
//        Player player13 = new Player("Rohit Sharma", "Batsman", team2);
//        Player player14 = new Player("Hardik Pandya", "All-rounder", team2);
//        Player player15 = new Player("Jasprit Bumrah", "Bowler", team2);
//        Player player16 = new Player("Kieron Pollard", "All-rounder", team2);
//        Player player17 = new Player("Quinton de Kock", "Wicketkeeper", team2);
//        Player player18 = new Player("Suryakumar Yadav", "Batsman", team2);
//        Player player19 = new Player("Ishan Kishan", "Batsman", team2);
//        Player player20 = new Player("Rahul Chahar", "Bowler", team2);
//        Player player21 = new Player("Trent Boult", "Bowler", team2);
//        Player player22 = new Player("Chris Lynn", "Batsman", team2);
//        Player player23 = new Player("Jayant Yadav", "All-rounder", team2);
//        Player player24 = new Player("Anukul Roy", "All-rounder", team2);
//
//        team2.addPlayer(player13);
//        team2.addPlayer(player14);
//        team2.addPlayer(player15);
//        team2.addPlayer(player16);
//        team2.addPlayer(player17);
//        team2.addPlayer(player18);
//        team2.addPlayer(player19);
//        team2.addPlayer(player20);
//        team2.addPlayer(player21);
//        team2.addPlayer(player22);
//        team2.addPlayer(player23);
//        team2.addPlayer(player24);
//
//        //Create Match1
//        
//        Match match1 = new Match(team1, team2);
//     
//        player1.updateStats(100, 30, 0);
//        player2.updateStats(30, 20, 0);
//        player3.updateStats(40, 25, 0);
//    
//        match1.updateScores(140, 0);
//        
//        //Create Match2
//
//        Match match2 = new Match(team2, team1);
//       
//        player13.updateStats(10, 40, 1);
//        player14.updateStats(12, 30, 0);
//        player15.updateStats(25, 20, 0);
//        match2.updateScores(139, 140);
//        
//        
//        //tournament 
//        Tournament tournament = new Tournament();
//        tournament.addTeam(team1);
//        tournament.addTeam(team2);
//        tournament.addMatch(match1);
//        tournament.addMatch(match2);
//        
//      
//
//        try {
//        	
//        	//check Team Length
//        	if(!(team1.getteamlength() == 12 && team2.getteamlength()==12)) {
//        		
//       		 throw new IllegalArgumentException("Team Lenth Should be 12 !!!!!");
//         	}
//        	
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter Your Query:");
//            String queryInput = scanner.nextLine();
//              
//            // Handling the user query
//            Player queriedPlayer = QueryHandler.handleQuery(queryInput, tournament);
//            
//   
//            if (queriedPlayer != null) {
//                if (queryInput.toLowerCase().contains("highest wicket taker") )
//                	if(!(queriedPlayer.getStats().getWicketsTaken()==0)) {
//                		 System.out.println("Highest wicket taker: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- " +queriedPlayer.getTeam().getTeamName() +", Wickets: " + queriedPlayer.getStats().getWicketsTaken());
//                	}else {
//                		System.out.println("No Wicket Taken in this match");
//                	}
//                   
//                else if (queryInput.toLowerCase().contains("50s"))
//                	if(!((queriedPlayer.getStats().getRunsScored()/50)==0)) {
//                		System.out.println("Player with most 50s: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- "+queriedPlayer.getTeam().getTeamName() + ", 50s: " + queriedPlayer.getStats().getRunsScored()/50);
//               	}else {
//               		System.out.println("No Player 50s Taken in this match");
//               	}
//                
//                else if (queryInput.toLowerCase().contains("strike rate"))
//                    System.out.println("Player with highest strike rate: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- "+queriedPlayer.getTeam().getTeamName() + ", Strike Rate: " + queriedPlayer.getStats().getStrikeRate());
//            } else {
//                System.out.println("Invalid Query.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//}
//
package Assignment_1;


