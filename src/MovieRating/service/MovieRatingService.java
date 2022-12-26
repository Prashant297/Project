package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.util.Map;

public interface MovieRatingService {
    void ratingDetail(Map<String, MovieRating> rateMap, Map<String, Movie> map);
    void displayAvgRating(Map<String,Float> hashMap);
    void displayRating(Map<String, MovieRating> maps);
    void ratingAverage(Map<String, MovieRating> rateMap, Map<String, Float> hashMap, String select);

}
