package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Movie> createMovies() {
        Movie movieOne = new Movie(
                "ARMY OF THE DEAD",
                LocalDate.of(2021, 5, 14),
                "From filmmaker Zack Snyder (300, Zack Snyder's Justice League), " +
                        "\nARMY OF THE DEAD takes place following a zombie outbreak that has left " +
                        "\nLas Vegas in ruins and walled off from the rest of the world.");

        Movie movieTwo = new Movie(
                "THE WOMAN IN THE WINDOW",
                LocalDate.of(2021, 5, 14),
                "Anna Fox (Amy Adams) is an agoraphobic child psychologist who finds " +
                        "\nherself keeping tabs on the picture perfect family across the street " +
                        "\nthrough the windows of her New York City brownstone. Her life is turned " +
                        "\nupside down when she inadvertently witnesses a brutal crime. ");

        Movie movieThree = new Movie("THE MITCHELLS VS. THE MACHINES",
                LocalDate.of(2021, 4, 23),
                "Young Katie Mitchell embarks on a road trip with her proud parents, " +
                        "\nyounger brother and beloved dog to start her first year at film school. " +
                        "\nBut their plans to bond as a family soon get interrupted when the world's " +
                        "\nelectronic devices come to life to stage an uprising.");

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movieOne);
        movieList.add(movieTwo);
        movieList.add(movieThree);

        return movieList;
    }

    public static List<Seans> createSeans(List<Movie> movieList) {
        List<Seans> seansList = new ArrayList<>();

        for(Movie movie: movieList) {
            seansList.add(new Seans(movie, LocalTime.of(12, 0)));
            seansList.add(new Seans(movie, LocalTime.of(15, 0)));
            seansList.add(new Seans(movie, LocalTime.of(18, 0)));
        }

        return seansList;
    }
}
