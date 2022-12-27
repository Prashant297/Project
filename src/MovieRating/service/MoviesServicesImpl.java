package MovieRating.service;

import MovieRating.Movie;
import MovieRating.MovieRating;

import java.time.LocalDate;
import java.util.*;

public class MoviesServicesImpl implements MoviesService{
    Scanner sc=new Scanner(System.in);
    MoviesFilterServiceImpl moviesFilterService = new MoviesFilterServiceImpl();
    MoviesValidationServicesImpl moviesValidationServices = new MoviesValidationServicesImpl();

    @Override
    public int movies(Map<String, Movie> map, int r, Map<String, MovieRating> ratemap) {
        switch (r) {
            case 1: movieMenu(map, ratemap);
                        return 0;
            case 2: if (displayMovies(map) == 1) {
                        System.out.println("No Data Available");
                        moviesValidationServices.role(map,ratemap);
                    } else
                        return 0;
            break;
            case 3:
                deleteOldMovies(map);
                break;
            case 4:
                updateMovie(map);
                break;
            case 5:
                filterMovies(map);
                break;
            default:
                break;
        }
        return r;
    }

    @Override
    public int displayMovies(Map<String, Movie> map) {
        if (map.isEmpty()){
            return 1;
        }
        moviesFilterService.movieFormat();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie = entry.getValue();
            System.out.println("Movie Id :"+entry.getKey());
            moviesFilterService.displayMovieFormat(movie);
       }
        return 0;
    }

    public void movieMenu(Map<String, Movie> map, Map<String, MovieRating> ratemap)  {
        int r;
        System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Delete Movie \n 4.Update \n 5.Filter \n 6.Exit");
        r=sc.nextInt();
        while (true) {
            switch (r){
                case 1:addMovie(map);
                break;
                case 2:displayMovies(map);
                break;
                case 3:deleteOldMovies(map);
                break;
                case 4:updateMovie(map);
                break;
                case 5:filterMovies(map);
                break;
                case 6:moviesValidationServices.role(map, ratemap);
                break;
                default:
                    System.out.println("NO such option available");
                    break;
            }
            System.out.println("Enter \n 1.Add Movie\n 2.Display Movie \n 3.Delete \n 4.Update \n 5.Filter \n 6.Exit");
            r=sc.nextInt();
        }
    }

    @Override
    public int addMovie(Map<String,Movie> map) {
        Movie movie = new Movie();
        int releaseYear;
        int currentPrice;
        int previousPrice;
        int income;
        String name;
        String cast;
        System.out.println("Enter Movie Name");
        name = sc.next();
        movie.setMovieName(name);
        System.out.println("Enter Release Year");
        releaseYear = sc.nextInt();
        movie.setReleaseYear(releaseYear);
        if (moviesValidationServices.checkYear(releaseYear) == 1) {
            return 1;
        }
        System.out.println("Enter cast");
        cast = sc.next();
        movie.setCast(cast);
        System.out.println("Enter current Price");
        currentPrice = sc.nextInt();
        movie.setCurrentPrice(currentPrice);
        System.out.println("Enter Previous Price");
        previousPrice = sc.nextInt();
        movie.setPreviousPrice(previousPrice);
        System.out.println("Enter income in crore");
        income = sc.nextInt();
        movie.setIncomeInCr(income);
        LocalDate localDate = LocalDate.now();
        movie.setDate(localDate);
        movie.setMovieStatus(moviesValidationServices.checkStatus(releaseYear));
        map.put(uniqeString(),new  Movie(movie.getMovieStatus(),movie.getMovieName(),movie.getReleaseYear(),movie.getCast(),
                movie.getCurrentPrice(),movie.getPreviousPrice(),movie.getIncomeInCr(),movie.getDate()));
        return 0;
    }

    @Override
    public int deleteOldMovies(Map<String,Movie> map) {
        if(displayMovies(map)==1) {
            System.out.println("NO Movie Exit");
            return 0;
        }
        System.out.println("Select Movie Id You Want To Delete");
        String delete = sc.next();
        if (map.containsKey(delete)){
            map.remove(delete);
            System.out.println("Deleted Successfully \n");
        }else {
            System.out.println("Movie id Doesn't exit");
        }
        return 0;
    }

    @Override
    public int updateMovie(Map<String, Movie> map) {
        if(displayMovies(map)==1) {
            System.out.println("NO Movie Exit");
            return 0;
        }
        System.out.println("Select Movie Id You Want To Update");
        String update = sc.next();
        if (map.containsKey(update)) {
            updateMovieField(map, update);
        }else{
            System.out.println("Movie Id doesn't Match\n");
        }
        return 0;
    }

    @Override
    public void updateMovieField(Map<String, Movie> map, String update) {
        String updateField;
        int updateInt;
        int field;
        System.out.println("""
                Select to Change\s
                1.Movie Name
                2.Release Year\s
                3.Cast
                4.Current Price
                5.Previous Price
                6.Income\s""");
        field = sc.nextInt();
        for (Map.Entry<String, Movie> entry : map.entrySet()) {
            Movie movie1 = entry.getValue();
            String key = entry.getKey();
            if (update.equals(key)) {
                    switch (field) {
                        case 1:
                            System.out.println("Enter Movie Name");
                            updateField = sc.next();
                            movie1.setMovieName(updateField);
                            break;
                        case 2:
                            System.out.println("Enter Release Year");
                            updateInt = sc.nextInt();
                            if (moviesValidationServices.checkYear(updateInt) == 1) {
                                break;
                            }
                            movie1.setMovieStatus(moviesValidationServices.checkStatus(updateInt));
                            movie1.setReleaseYear(updateInt);
                            break;
                        case 3:
                            System.out.println("Enter CAst");
                            updateField = sc.next();
                            movie1.setCast(updateField);
                            break;
                        case 4:
                            System.out.println("Enter Current price");
                            updateInt = sc.nextInt();
                            movie1.setCurrentPrice(updateInt);
                            break;
                        case 5:
                            System.out.println("Enter Previous Price");
                            updateInt = sc.nextInt();
                            movie1.setPreviousPrice(updateInt);
                            break;
                        case 6:
                            System.out.println("Enter Income ");
                            updateInt = sc.nextInt();
                            movie1.setIncomeInCr(updateInt);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

    @Override
    public void filterMovies(Map<String, Movie> map) {
        System.out.println("Filter\n1.Status\n2.Year\n3.Cast\n4.Movie Name\n5.Status And Year");
        int filter = sc.nextInt();
        switch (filter){
            case 1:moviesFilterService.statusFilter(map);
            break;
            case 2:moviesFilterService.yearFilter(map);
            break;
            case 3: moviesFilterService.castFilter(map);
            break;
            case 4:moviesFilterService.movieNameFilter(map);
            break;
            case 5:moviesFilterService.yearStatusFilter(map);
            break;
            default:break;
        }
    }

    @Override
    public String uniqeString() {
            UUID uniqueString = UUID.randomUUID();
            return uniqueString.toString().substring(30);
    }
}

