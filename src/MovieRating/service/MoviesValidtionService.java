package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.util.List;
import java.util.Map;

public interface MoviesValidtionService {
    void role(Map<String, Movie> map, Map<String, MovieRating> rateMap);
    int checkMovieId(Map<String, Movie> map, String mid, List<String> list);
    int checkRating(int rate);
    int checkYear(int releaseYear);
    MovieRatingServiceImpl.movieStatus checkStatus(int year);
}
