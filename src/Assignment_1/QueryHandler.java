// QueryHandler.java
package Assignment_1;

public class QueryHandler {
    public static Player handleQuery(String query, Tournament tournament) {
        switch (query.toLowerCase()) {
            case "who is the highest wicket taker of all time?":
                return tournament.getHighestWicketTaker();
            case "who has scored maximum numbers of 50s?":
                return tournament.getPlayerWithMost50s();
            case "who has highest strike rate?":
                return tournament.getPlayerWithHighestStrikeRate();
            default:
                return null;
        }
    }
}
