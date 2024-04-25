// IPLTournamentManager.java
package Assignment_1;

import java.util.Scanner;

public class IPLTournamentManager {
    public static void main(String[] args) {
        // Initialize tournament and teams
        Tournament tournament = new Tournament();
        // Add teams and matches to the tournament
        // ...

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Query:");
            String queryInput = scanner.nextLine();

            Player queriedPlayer = QueryHandler.handleQuery(queryInput, tournament);
            // Handle the queried player
            // ...
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
