package movieRating.service;

import movieRating.Movie;

import java.util.List;
import java.util.Map;

public interface MoviesSearchServices {
    void statusSearch(Map<String, Movie>map);
    void yearSearch(Map<String, Movie>map);
    void castSearch(Map<String, Movie>map);
    void movieNameSearch(Map<String, Movie>map);
    void movieFormat();
    void displayMovieFormat(Movie movie);
    void yearStatusSearch(Map<String, Movie>map);
    String statusSelection();
    List<Integer> sortedYearList(Map<String, Movie>map);
}
