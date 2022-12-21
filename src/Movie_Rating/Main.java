package Movie_Rating;

import Movie_Rating.service.MovieRatingService;
import Movie_Rating.service.MovieRatingServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Map<Integer,Movie> map = new HashMap<>();
        final Map<String,MovieRating> rateMap = new HashMap<>();
        MovieRatingService service = new MovieRatingServiceImpl();
        service.role(map,rateMap);
    }
}

