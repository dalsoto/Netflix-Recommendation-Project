import java.util.HashMap;
import java.util.Map;

public class NetflixRecommendationSystem {

    private NetflixData netflixData;

    public NetflixRecommendationSystem(NetflixData netflixData) {
        this.netflixData = netflixData;
    }

    public Map<String, Double> getRecommendations(String userId) {
        Map<String, Double> userRatings = netflixData.getUserItemRatings().getOrDefault(userId, new HashMap<>());
        Map<String, Double> recommendations = new HashMap<>();

        // Iterate over other users
        for (String otherUser : netflixData.getUserItemRatings().keySet()) {
            if (!otherUser.equals(userId)) {
                Map<String, Double> otherUserRatings = netflixData.getUserItemRatings().get(otherUser);

                // Calculate similarity between the current user and other users
                double similarity = UserSimilarityCalculator.calculateCosineSimilarity(userRatings, otherUserRatings);

                if (similarity > 0.0) {
                    // Iterate over items rated by other users
                    for (Map.Entry<String, Double> entry : otherUserRatings.entrySet()) {
                        String item = entry.getKey();
                        double rating = entry.getValue();

                        // Check if the current user has not rated the item
                        if (!userRatings.containsKey(item)) {
                            // Weighted sum of ratings based on similarity
                            recommendations.merge(item, rating * similarity, Double::sum);
                        }
                    }
                }
            }
        }

        return recommendations;
    }

    public static void main(String[] args) {
        NetflixData netflixData = new NetflixData();

        // Example: Adding ratings for users and items
        netflixData.addRating("user1", "movie1", 4.5);
        netflixData.addRating("user1", "movie2", 3.0);
        netflixData.addRating("user2", "movie1", 5.0);
        netflixData.addRating("user2", "movie2", 2.5);
        netflixData.addRating("user3", "movie1", 2.0);
        netflixData.addRating("user3", "movie3", 4.0);

        NetflixRecommendationSystem recommendationSystem = new NetflixRecommendationSystem(netflixData);

        // Example: Get recommendations for user1
        String userId = "user3";
        Map<String, Double> recommendations = recommendationSystem.getRecommendations(userId);

        // Print recommendations
        System.out.println("Recommendations for user " + userId + ": " + recommendations);
    }
}

