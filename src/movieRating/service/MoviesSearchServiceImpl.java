package movieRating.service;

import movieRating.Movie;

import java.util.*;

public class MoviesSearchServiceImpl implements MoviesSearchServices {
    final Scanner sc = new Scanner(System.in);

    @Override
    public void statusSearch(Map<String, Movie> map) {
        String status=statusSelection();
        movieFormat();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            if (movie.movieStatus.name().equals(status)) {
                System.out.println("Movie Id " + entry.getKey());
                displayMovieFormat(movie);
            }
        }
    }

    @Override
    public void yearSearch(Map<String, Movie> map) {
        movieFormat();
        List<Integer> yearList = sortedYearList(map);
        for (int i = 0; map.size() > i; i++) {
            for (Map.Entry<String, Movie> entry : map.entrySet()) {
                Movie movie = entry.getValue();
                if (yearList.get(i) == movie.getReleaseYear()) {
                    System.out.println("Movie Id " + entry.getKey());
                    displayMovieFormat(movie);
                }
            }
        }
    }

    @Override
    public void castSearch(Map<String, Movie> map) {
        System.out.println("Enter Movie Cast to Filter");
        String cast = sc.next();
        movieFormat();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            if (cast.equalsIgnoreCase(movie.getCast())) {
                displayMovieFormat(movie);
            }
        }
    }
    @Override
    public void movieNameSearch(Map<String, Movie> map) {
        System.out.println("Select \n1.Ascending \n2.Descending");
        int select= sc.nextInt();
        movieFormat();
        List<String> movieNameList = new ArrayList<>();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            movieNameList.add(movie.getMovieName());
        }
        switch (select){
            case 1:Collections.sort(movieNameList);
            break;
            case 2:
                movieNameList.sort(Collections.reverseOrder());
            break;
            default:break;
        }
        for (int i = 0; map.size() > i; i++) {
            for (Map.Entry<String, Movie> entry : map.entrySet()) {
                Movie movie = entry.getValue();
                if (movieNameList.get(i).equals(movie.getMovieName())) {
                    System.out.println("Movie Id " + entry.getKey());
                    displayMovieFormat(movie);
                 }
            }
        }
    }

    @Override
    public void movieFormat(){
            System.out.printf("%10s %15s %10s %20s %20s %15s %10s %15s", "Movie Name", "Release Year",
                    "Cast", "Current Price", "Previous Price", "Income cr.", "Status","Added Date");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        }

    @Override
    public void displayMovieFormat(Movie movie) {
        System.out.format("%10s  %10d %15s %20d %15d %15d %15s \t\t%tF%n", movie.getMovieName(),
                movie.getReleaseYear(), movie.getCast(), movie.getCurrentPrice(), movie.getPreviousPrice(),
                movie.getIncomeInCr(), movie.getMovieStatus(),movie.getDate(), "\n");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void yearStatusSearch(Map<String, Movie>map) {
        String status = statusSelection();
        List<Integer> yearList = sortedYearList(map);
        movieFormat();

        for (int i = 0; map.size() > i; i++) {
            for (Map.Entry<String, Movie> entry : map.entrySet()) {
                Movie movie = entry.getValue();
                if (movie.movieStatus.name().equals(status) && yearList.get(i) == movie.getReleaseYear()) {
                    System.out.println("Movie Id " + entry.getKey());
                    displayMovieFormat(movie);
                }
            }
        }
    }

    @Override
    public String statusSelection() {
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
        return status;
    }

    @Override
    public List<Integer> sortedYearList(Map<String, Movie>map) {
        List<Integer> yearList = new ArrayList<>();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            yearList.add(movie.getReleaseYear());
        }
        Collections.sort(yearList);
        return yearList;
    }

}



