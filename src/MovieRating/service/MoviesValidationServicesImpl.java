package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MoviesValidationServicesImpl implements MoviesValidtionService{


    @Override
    public void role(Map<String, Movie> map, Map<String, MovieRating> rateMap) {
        Scanner sc = new Scanner(System.in);
        MoviesServicesImpl moviesService = new MoviesServicesImpl();
        MovieRatingServiceImpl movieRatingService = new MovieRatingServiceImpl();

        Map<String,Integer> adminLogin = new HashMap<>();
        adminLogin.put("Prashant",1234);

        int r;
        System.out.println("Login as \n1.Admin \n 2.User \n 3.Exit");
        r = sc.nextInt();
        switch (r) {
            case 1:
                System.out.println("Enter Admin Id");
                String adminId= sc.next();
                System.out.println("Enter Password");
                int password=sc.nextInt();
                if (adminLogin.containsKey(adminId) && adminLogin.containsValue(password))
                {
                    moviesService.movies(map,r,rateMap);
                }else {
                    System.out.println("Invalid AdminId or Password");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    role(map,rateMap);
                }
                break;
            case 2:
                if(moviesService.movies(map, r, rateMap)==1){break;}
                System.out.println("Welcome to Rating Interface");
                System.out.println("Rate the Movies");
                movieRatingService.ratingDetail(rateMap, map);
                break;
            default:
                break;
        }
    }
    @Override
    public int checkYear(int releaseYear) {
        if (releaseYear<1800 || releaseYear>3000) {
            System.out.println("Cannot enter Movie year less than 1800 and more than 3000");
            return 1;
        }
        return 0;
    }
    @Override
    public int checkMovieId(Map<String, Movie> map, String mid, List<String> list) {
        MovieRatingServiceImpl.movieStatus enumVal = MovieRatingServiceImpl.movieStatus.FUTURE;
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            String key = entry.getKey();
            Movie mv = entry.getValue();
            if ((key.equals(mid)) && (enumVal.equals(mv.movieStatus))) {
                System.out.println("You can't rate the Upcoming Movie");
                return 1;
            }
        }
        if (list.contains(mid)) {
            System.out.println("You cannot insert same movie id twice ");
            System.out.println();
            return 1;
        }
        list.add(mid);
        if (!map.containsKey(mid)) {
            return 1;
        }
        return 0;
    }
    @Override
    public int checkRating(int rate) {
        if (rate < 0 || rate > 5) {
            System.out.println("Invalid rating");
            return 1;
        }
        return 0;
    }
    @Override
    public MovieRatingServiceImpl.movieStatus checkStatus(int year) {
        if (year < 2022) {
            return MovieRatingServiceImpl.movieStatus.PAST;
        } else if (year == 2022) {
            return MovieRatingServiceImpl.movieStatus.PRESENT;
        } else {
            return MovieRatingServiceImpl.movieStatus.FUTURE;
        }
    }
}
