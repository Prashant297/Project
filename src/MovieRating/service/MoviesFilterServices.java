package MovieRating.service;

import MovieRating.Movie;

import java.util.Map;

public interface MoviesFilterServices {
    void statusFilter(Map<String, Movie>map);
    void yearFilter(Map<String, Movie>map);
    void rateFilter(Map<String, Movie>map);
}
