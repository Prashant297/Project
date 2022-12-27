package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MovieRatingServiceImpl implements MovieRatingService{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");

    public enum movieStatus {
        PAST,
        PRESENT,
        FUTURE

    }
    @Override
    public void ratingAverage(Map<String, MovieRating> rateMap, Map<String, Float> movieRatingMap, String select) {
        float count=1;
        float star=0;
        float n;
        for (Map.Entry<String, MovieRating> entry : rateMap.entrySet()) {
            MovieRating movieRating = entry.getValue();
            if (movieRating.getMovieId().equals(select)) {
                star = star + movieRating.getRating();
                n = (star / count);
                count++;
                movieRatingMap.put(movieRating.getMovieId(), n);
            }
        }
        displayAvgRating(movieRatingMap);
    }

    @Override
    public void displayAvgRating(Map<String, Float> hashMap) {
        System.out.print("Movies Rating");
        System.out.println("\nMovie id\t Movie rating \t");

        for (Map.Entry<String,Float> entry: hashMap.entrySet()){
            System.out.println( "\t"+entry.getKey()+"\t\t\t"+entry.getValue());
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }
    @Override
    public void ratingDetail(Map<String, MovieRating> rateMap, Map<String, Movie> map) {
        Scanner sc = new Scanner(System.in);
       final Map<String, Float> movieRatingMap = new HashMap<>();
        final List<String> list = new ArrayList<>();
        MovieRatingServiceImpl movieRatingService = new MovieRatingServiceImpl();
        MoviesValidationServicesImpl moviesValidationServices = new MoviesValidationServicesImpl();
        final MovieRating movieRating = new MovieRating();
        int i = 0;
        String movieId;
        int rate;
        String describe;

        System.out.println("Enter user id");
        int use = sc.nextInt();
        movieRating.setUserId(use);
        while (true) {
            System.out.println("Select  Movie id you want to Rate");
            movieId = sc.next();
            movieRating.setMovieId(movieId);

            if (moviesValidationServices.checkMovieId(map, movieId, list) == 1) {
                System.out.println("Invalid MovieID");
                System.out.println("-----------------------------------------");
                System.out.println();
                moviesValidationServices.role(map, rateMap);
            }
            System.out.println("Give rating");
            rate = sc.nextInt();
            movieRating.setRating(rate);
            if (moviesValidationServices.checkRating(rate) == 1) {
                moviesValidationServices.role(map, rateMap);
            }
            System.out.println("Describe about movie");
            describe = sc.next();
            movieRating.setDescription(describe);
            System.out.println();

            LocalDateTime localDateTime = LocalDateTime.now();
            String dateTime = localDateTime.format(formatter);
            rateMap.put(dateTime, new MovieRating(movieRating.getUserId(),movieRating.getMovieId(),
                    movieRating.getRating(), movieRating.getDescription()));

            System.out.println("Enter \n 1.Continue \n 2.Display \n 3.Exit ");
            i = sc.nextInt();
            if (i == 2) {
                movieRatingService.displayRating(rateMap);
                movieRatingService.ratingAverage(rateMap, movieRatingMap, movieId);
                System.out.println("Enter \n 1.Continue \n 2.Display \n 3.Exit ");
                i = sc.nextInt();
            }
            if (i == 3) {
                moviesValidationServices.role(map, rateMap);
            }
        }


    }
    @Override
    public void displayRating(Map<String, MovieRating> maps) {
        System.out.printf("%10s %15s %10s %20s %10s", "User ID", "Movie ID", "Rating", "Description", "Date\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<String, MovieRating> entry : maps.entrySet()) {
            MovieRating s = entry.getValue();
            System.out.format("%10s %15s %10s %15s %15s", s.getUserId(), s.getMovieId(), s.getRating(), s.getDescription(),"\t\t"+ entry.getKey()+"\n");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
}
