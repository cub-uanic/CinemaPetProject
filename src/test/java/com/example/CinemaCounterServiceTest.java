package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaCounterServiceTest extends TestCase {

    private static CinemaCounterService cinemaCounterService;

    @BeforeAll
    static void createCinemaCounterServiceInstant() {
        cinemaCounterService = new CinemaCounterService();
    }

    @Test
    @DisplayName("CinemaCounterService should create a user")
    void shouldCreateUser() {
        String userName = "Alex";
        User user = cinemaCounterService.createUser(userName);
        assertNotNull(user);

    }

    @Test
    @DisplayName("CinemaCounterService should not create a user if userName is null")
    void shouldThrowRunTimeExceptionIfUserNameIsNull() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> cinemaCounterService.createUser(null));
    }

    @Test
    @DisplayName("CinemaCounterService should choose movie from movie list based on movie name")
    void shouldChooseMovieFromMovieList() {
        List<Movie> movieList = Helper.createMovies();
        Movie movieOne = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        movieList.add(movieOne);
        Movie movie = cinemaCounterService.chooseMovie(movieList, "Name");
        Assertions.assertEquals(movieOne, movie);
    }

    @Test
    @DisplayName("CinemaCounterService should choose seans from seans list " +
            "based on movie instance, seans list and user input: seans #3")
    void shouldChooseSeansFromSeansList() {
        List<Movie> movieList = Helper.createMovies();
        List<Seans> seansList = Helper.createSeans(movieList);
        Movie movie = movieList.get(0);


        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Seans seans = cinemaCounterService.chooseSeans(movie, seansList);

        Assertions.assertEquals(movie, seans.getMovie());
    }

    @Test
    @DisplayName("CinemasCounterService should choose seat based on given seans " +
            "based on user input: seat #12")
    void shouldChooseSeatFromSeans() {
        Movie movie = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        Seans seans = new Seans(movie, LocalTime.of(16,0));

        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Seat seat = cinemaCounterService.chooseSeat(seans);

        Assertions.assertEquals(12, seat.getSeatNumber());
    }

    @Test
    @DisplayName("CinemaCounterService should create ticket based on provided " +
            "seans and seat")
    void shouldCreateTicketBasedOnSeansAndSeat() throws Exception {
        Movie movie = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        Seans seans = new Seans(movie, LocalTime.of(16,0));
        Seat seat = new Seat(10);

        Ticket ticket = cinemaCounterService.createTicket(seans, seat);

        Assertions.assertFalse(ticket.getSeat().isFree());
    }


    @Test
    @DisplayName("CinemaCounterService should create ticket based on provided " +
            "seans and seat")
    void shouldMarkSeatAsBusyAfterCreationOfTicket()  throws Exception {
        Movie movie = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        Seans seans = new Seans(movie, LocalTime.of(16,0));
        Seat seat = new Seat(10);

        Ticket ticket = cinemaCounterService.createTicket(seans, seat);

        Assertions.assertFalse(ticket.getSeat().isFree());
    }

}