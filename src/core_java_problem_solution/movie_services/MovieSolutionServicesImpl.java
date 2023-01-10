package core_java_problem_solution.movie_services;

import java.util.*;

public class MovieSolutionServicesImpl implements MovieSolutionServices{


    @Override
    public List<Movies> addMovie() {
        Scanner scanner = new Scanner(System.in);

        List<Movies> moviesList = new ArrayList<>();
        System.out.println("Enter number of Movies you want ");
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++) {
            Movies movies = new Movies();
            System.out.println("Enter Movie Name");
            movies.setMovieName(scanner.next());
            System.out.println("Enter Company");
            movies.setCompany(scanner.next());
            System.out.println("Enter Genre");
            movies.setGenre(scanner.next());
            System.out.println("Enter Budget");
            movies.setBudget(scanner.nextInt());

            moviesList.add(movies);
    }
        return moviesList;
    }
    static List<Movies> getMovieByGenre(String genre, List<Movies> moviesList){
        List<Movies> genreList = new ArrayList<>();
        for (Movies movies: moviesList){
            if (movies.getGenre().equals(genre)){
                genreList.add(movies);
            }
        }
        return genreList;
    }
}