package com.example;

import java.time.LocalDate;

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
}
