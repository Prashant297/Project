package Movie_Rating;

import Movie_Rating.service.MovieRatingServiceImpl;

public class Movie {
    public MovieRatingServiceImpl.movieStatus movieStatus;
    String movieName;
    int releaseYear;
    String cast;
    int currentPrice;
    int previousPrice;
    int incomeInCr;

    public String getMovieName() {
        return movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCast() {
        return cast;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getPreviousPrice() {
        return previousPrice;
    }

    public int getIncomeInCr() {
        return incomeInCr;
    }

    public Movie(String movieName, int releaseDate, String cast, int currentPrice, int previousPrice, int incomeInCr, MovieRatingServiceImpl.movieStatus movieStatus) {
        this.movieName = movieName;
        this.releaseYear = releaseDate;
        this.cast = cast;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
        this.incomeInCr = incomeInCr;
        this.movieStatus = movieStatus;
    }
}
