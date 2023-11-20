import java.util.HashMap;
import java.util.Map;

public class NetflixData {

    private Map<String, Map<String, Double>> userItemRatings;

    public NetflixData() {
        userItemRatings = new HashMap<>();
    }

    public void addRating(String userId, String itemId, double rating) {
        userItemRatings.computeIfAbsent(userId, k -> new HashMap<>()).put(itemId, rating);
    }

    public Map<String, Map<String, Double>> getUserItemRatings() {
        return userItemRatings;
    }

    public static void main(String[] args) {
        NetflixData netflixData = new NetflixData();

        // Example: Adding ratings for users and items
        netflixData.addRating("user1", "movie1", 4.5);
        netflixData.addRating("user1", "movie2", 3.0);
        netflixData.addRating("user2", "movie1", 5.0);
        netflixData.addRating("user2", "movie2", 2.5);

        // Access the user-item ratings
        Map<String, Map<String, Double>> userItemRatings = netflixData.getUserItemRatings();
        System.out.println("User-Item Ratings: " + userItemRatings);
    }
}
