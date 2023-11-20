# Netflix-Recommendation-Project

This project implements a simple recommendation system for a hypothetical Netflix-like service using Java. The recommendation system provides personalized movie recommendations for users based on their ratings and the ratings of other users in the dataset. The system uses collaborative filtering, specifically cosine similarity, to calculate user similarities and generate recommendations.

Files:
1. NetflixData.java
This file defines the NetflixData class, representing the dataset for user-item ratings. It includes methods to add ratings for users and items, and a method to access the user-item ratings.

2. UserSimilarityCalculator.java
The UserSimilarityCalculator class contains methods for calculating cosine similarity between two users based on their ratings. It is a crucial component for determining user similarities in the recommendation system.

3. NetflixRecommendationSystem.java
This is the main class that represents the Netflix recommendation system. It utilizes the NetflixData class for storing user-item ratings and the UserSimilarityCalculator class to calculate user similarities. The getRecommendations method generates personalized recommendations for a given user based on their ratings and the ratings of similar users.
