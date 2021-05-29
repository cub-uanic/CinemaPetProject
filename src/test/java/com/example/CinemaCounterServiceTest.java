package com.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
}