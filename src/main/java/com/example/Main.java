package com.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CinemaCounterService cinemaCounterService = new CinemaCounterService();
        User user = cinemaCounterService.greetUser();
        List<Movie> movieList = Helper.createMovies();
        List<Seans> seansList = Helper.createSeans(movieList);
        Movie chosenMovie = cinemaCounterService.chooseMovie(movieList);
        Seans chosenSeans = cinemaCounterService.chooseSeans(chosenMovie, seansList);
        Seat chosenSeat = cinemaCounterService.chooseSeat(chosenSeans);
        Ticket ticket = cinemaCounterService.createTicket(chosenSeans, chosenSeat);
        user.purchaseTicket(ticket);
        // the next step is to offer user to purchase another ticket or go and watch a movie
    }

}
