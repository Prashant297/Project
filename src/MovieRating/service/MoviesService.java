package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.util.Map;

public interface MoviesService {
    int movies(Map<String, Movie> map, int r, Map<String, MovieRating> ratemap);
    int displayMovies(Map<String, Movie> map);
    void movieMenu(Map<String, Movie> map, Map<String,MovieRating> ratemap);
    int addMovie(Map<String,Movie>map);
    int deleteOldMovies(Map<String,Movie>map);
    int updateMovie(Map<String,Movie>map);
    void updateMovieField(Map<String ,Movie>map, String update);
    void filterMovies(Map<String, Movie> map);
    String uniqeString();

}
