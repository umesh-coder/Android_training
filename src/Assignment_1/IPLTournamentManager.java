// IPLTournamentManager.java
package Assignment_1;

import java.util.Scanner;

public class IPLTournamentManager {
    public static void main(String[] args) {
        // Hardcoded data
    	
    	//create Team
        Team team1 = new Team("CSK", "Ground A");
        Team team2 = new Team("MI", "Ground B");

        //added player in Team
        Player player1 = new Player("M.S Dhoni", "Wicketkeeper", team1);
        Player player2 = new Player("Ravindra Jadeja", "All-rounder", team1);
        Player player3 = new Player("Suresh Raina", "Batsman", team1);
        Player player4 = new Player("Ambati Rayudu", "Batsman", team1);
        Player player5 = new Player("Faf du Plessis", "Batsman", team1);
        Player player6 = new Player("Shane Watson", "All-rounder", team1);
        Player player7 = new Player("Imran Tahir", "Bowler", team1);
        Player player8 = new Player("Deepak Chahar", "Bowler", team1);
        Player player9 = new Player("Sam Curran", "All-rounder", team1);
        Player player10 = new Player("Lungi Ngidi", "Bowler", team1);
        Player player11 = new Player("Murali Vijay", "Batsman", team1);
        Player player12 = new Player("Kedar Jadhav", "All-rounder", team1);

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        team1.addPlayer(player6);
        team1.addPlayer(player7);
        team1.addPlayer(player8);
        team1.addPlayer(player9);
        team1.addPlayer(player10);
        team1.addPlayer(player11);
        team1.addPlayer(player12);
        
        
        //added player in Team

        Player player13 = new Player("Rohit Sharma", "Batsman", team2);
        Player player14 = new Player("Hardik Pandya", "All-rounder", team2);
        Player player15 = new Player("Jasprit Bumrah", "Bowler", team2);
        Player player16 = new Player("Kieron Pollard", "All-rounder", team2);
        Player player17 = new Player("Quinton de Kock", "Wicketkeeper", team2);
        Player player18 = new Player("Suryakumar Yadav", "Batsman", team2);
        Player player19 = new Player("Ishan Kishan", "Batsman", team2);
        Player player20 = new Player("Rahul Chahar", "Bowler", team2);
        Player player21 = new Player("Trent Boult", "Bowler", team2);
        Player player22 = new Player("Chris Lynn", "Batsman", team2);
        Player player23 = new Player("Jayant Yadav", "All-rounder", team2);
        Player player24 = new Player("Anukul Roy", "All-rounder", team2);

        team2.addPlayer(player13);
        team2.addPlayer(player14);
        team2.addPlayer(player15);
        team2.addPlayer(player16);
        team2.addPlayer(player17);
        team2.addPlayer(player18);
        team2.addPlayer(player19);
        team2.addPlayer(player20);
        team2.addPlayer(player21);
        team2.addPlayer(player22);
        team2.addPlayer(player23);
        team2.addPlayer(player24);

        //Create Match1
        
        Match match1 = new Match(team1, team2);
     
        player1.updateStats(100, 30, 0);
        player2.updateStats(30, 20, 0);
        player3.updateStats(40, 25, 0);
    
        match1.updateScores(140, 0);
        
        //Create Match2

        Match match2 = new Match(team2, team1);
       
        player13.updateStats(10, 40, 1);
        player14.updateStats(12, 30, 0);
        player15.updateStats(25, 20, 0);
        match2.updateScores(139, 140);
        
        
        //tournament 
        Tournament tournament = new Tournament();
        tournament.addTeam(team1);
        tournament.addTeam(team2);
        tournament.addMatch(match1);
        tournament.addMatch(match2);
        
      

        try {
          	
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Query:");
            String queryInput = scanner.nextLine();
              
            // Handling the user query
            Player queriedPlayer = QueryHandler.handleQuery(queryInput, tournament);
            
   
            if (queriedPlayer != null) {
                if (queryInput.toLowerCase().contains("highest wicket taker") )
                	if(!(queriedPlayer.getStats().getWicketsTaken()==0)) {
                		 System.out.println("Highest wicket taker: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- " +queriedPlayer.getTeam().getTeamName() +", Wickets: " + queriedPlayer.getStats().getWicketsTaken());
                	}else {
                		System.out.println("No Wicket Taken in this match");
                	}
                   
                else if (queryInput.toLowerCase().contains("50s"))
                	if(!((queriedPlayer.getStats().getRunsScored()/50)==0)) {
                		System.out.println("Player with most 50s: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- "+queriedPlayer.getTeam().getTeamName() + ", 50s: " + queriedPlayer.getStats().getRunsScored()/50);
               	}else {
               		System.out.println("No Player 50s Taken in this match");
               	}
                
                else if (queryInput.toLowerCase().contains("strike rate"))
                    System.out.println("Player with highest strike rate: " + queriedPlayer.getPlayerName() + ", Role: " + queriedPlayer.getRole() +", Team Name:- "+queriedPlayer.getTeam().getTeamName() + ", Strike Rate: " + queriedPlayer.getStats().getStrikeRate());
            } else {
                System.out.println("Invalid Query.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}




