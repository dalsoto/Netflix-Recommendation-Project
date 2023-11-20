import java.util.Map;

public class UserSimilarityCalculator {

    public static double calculateCosineSimilarity(Map<String, Double> ratings1, Map<String, Double> ratings2) {
        // Ensure the rating maps are not empty
        if (ratings1.isEmpty() || ratings2.isEmpty()) {
            return 0.0;
        }

        // Calculate cosine similarity between two users based on their ratings
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;

        for (Map.Entry<String, Double> entry : ratings1.entrySet()) {
            String item = entry.getKey();
            double rating1 = entry.getValue();
            double rating2 = ratings2.getOrDefault(item, 0.0);

            dotProduct += rating1 * rating2;
            norm1 += Math.pow(rating1, 2);
            norm2 += Math.pow(rating2, 2);
        }

        if (norm1 == 0.0 || norm2 == 0.0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, Double> user1Ratings = Map.of("movie1", 4.5, "movie2", 3.0);
        Map<String, Double> user2Ratings = Map.of("movie1", 5.0, "movie2", 2.5);

        // Call calculateCosineSimilarity method with user ratings
        double similarity = calculateCosineSimilarity(user1Ratings, user2Ratings);

        // Print the result
        System.out.println("Cosine Similarity: " + similarity);
    }
}
