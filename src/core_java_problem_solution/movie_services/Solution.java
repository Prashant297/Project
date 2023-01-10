package core_java_problem_solution.movie_services;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieSolutionServicesImpl movieSolutionServices = new MovieSolutionServicesImpl();
        List<Movies> moviesList = new ArrayList<>(movieSolutionServices.addMovie());
        System.out.println("Enter Movie Genre");
        String genre = scanner.next();

        List<Movies> genreList = new ArrayList<>(MovieSolutionServicesImpl.getMovieByGenre(genre,moviesList));

        for (Movies movies : genreList){
            if (movies.getBudget()>80000000) System.out.println("High Budget Movie");
            else System.out.println("Low Budget Movie");
        }

    }
}
