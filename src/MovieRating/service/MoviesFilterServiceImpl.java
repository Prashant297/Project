package MovieRating.service;

import MovieRating.Movie;

import java.security.Key;
import java.util.*;
import java.util.concurrent.Future;

public class MoviesFilterServiceImpl implements MoviesFilterServices {
    Scanner sc = new Scanner(System.in);
    @Override
    public void statusFilter(Map<String, Movie> map) {
        int select;
        String status = null;
        System.out.println("Select Status\n1.PAST\n2.PRESENT\n3.FUTURE");
        select = sc.nextInt();
        switch (select) {
            case 1:
                status = "PAST";
                break;
            case 2:
                status = "PRESENT";
                break;
            case 3:
                status = "FUTURE";
                break;
            default:
                break;
        }
        System.out.printf("%10s %15s %10s %20s %20s %15s %10s", "Movie Name", "Release Year",
                "Cast", "Current Price", "Previous Price", "Income cr.", "Status");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie stat = entry.getValue();
            if (stat.movieStatus.name().equals(status)) {
                System.out.println("Movie Id " + entry.getKey());
                System.out.format("%10s  %10s %20s %10s %20s %15s %15s", stat.getMovieName(),
                        stat.getReleaseYear(), stat.getCast(), stat.getCurrentPrice(), stat.getPreviousPrice(),
                        stat.getIncomeInCr(), stat.getMovieStatus(), "\n");
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    }

    @Override
    public void yearFilter(Map<String, Movie> map) {
        System.out.printf("%10s %15s %10s %20s %20s %15s %10s", "Movie Name", "Release Year",
                "Cast", "Current Price", "Previous Price", "Income cr.", "Status");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        List<Integer> yearList = new ArrayList<>();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            yearList.add(movie.getReleaseYear());
        }
        Collections.sort(yearList);
        for (int i = 0; map.size() > i; i++) {
            for (Map.Entry<String, Movie> entry : map.entrySet()) {
                Movie movie = entry.getValue();
                if (yearList.get(i) == movie.getReleaseYear()) {
                    System.out.println("Movie Id " + entry.getKey());
                    System.out.format("%10s  %10s %20s %10s %20s %15s %15s", movie.getMovieName(),
                            movie.getReleaseYear(), movie.getCast(), movie.getCurrentPrice(), movie.getPreviousPrice(),
                            movie.getIncomeInCr(), movie.getMovieStatus(), "\n");
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }

    @Override
    public void rateFilter(Map<String, Movie>map) {
        System.out.println("Select Movie Rate to Filter");
        int rate = sc.nextInt();
        System.out.printf("%10s %15s %10s %20s %20s %15s %10s", "Movie Name", "Release Year",
                "Cast", "Current Price", "Previous Price", "Income cr.", "Status");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
}

