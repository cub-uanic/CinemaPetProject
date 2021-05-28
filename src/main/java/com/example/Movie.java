package com.example;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {
    private String movieName;
    private LocalDate movieReleaseTime;
    private String movieDescription;

    public Movie(String movieName, LocalDate movieReleaseTime, String movieDescription) {
        this.movieName = movieName;
        this.movieReleaseTime = movieReleaseTime;
        this.movieDescription = movieDescription;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getMovieReleaseTime() {
        return movieReleaseTime;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    @Override
    public String toString() {
        return movieName +
                "\nmovieReleaseTime: " + movieReleaseTime +
                "\nmovieDescription: " + movieDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieName.equals(movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName);
    }
}
