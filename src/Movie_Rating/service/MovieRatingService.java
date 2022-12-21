package Movie_Rating.service;

import Movie_Rating.Movie;
import Movie_Rating.MovieRating;

import java.util.List;
import java.util.Map;

public interface MovieRatingService {

    int checkMovieId(Map<Integer, Movie> map, Integer mid, List<Integer> list);
    int checkRating(int rate);
    int checkYear(int releaseYear);
    MovieRatingServiceImpl.movieStatus checkStatus(int year);
    void role(Map<Integer, Movie> map,Map<String, MovieRating> rateMap);
    void movies(Map<Integer, Movie> map, int r, Map<String, MovieRating> ratemap);
    void displayMovies(Map<Integer, Movie> map);
    void addMovie(Map<Integer, Movie> map,Map<String,MovieRating> ratemap);
    void ratingDetail(Map<String, MovieRating> rateMap, Map<Integer, Movie> map);
    void displayAvg(Map<Integer,Float> hashMap);
    void displayRating(Map<String, MovieRating> maps);
    void ratingAverage(Map<String, MovieRating> rateMap, Map<Integer, Float> hashMap, int select);
}
