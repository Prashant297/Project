package MovieRating.service;

import MovieRating.Movie;

import java.util.List;
import java.util.Map;

public interface MoviesFilterServices {
    void statusFilter(Map<String, Movie>map);
    void yearFilter(Map<String, Movie>map);
    void castFilter(Map<String, Movie>map);
    void movieNameFilter(Map<String, Movie>map);
    void movieFormat();
    void displayMovieFormat(Movie movie);
    void  yearStatusFilter(Map<String, Movie>map);
    String statusSelection();
    List<Integer> sortedYearList(Map<String, Movie>map);
}
