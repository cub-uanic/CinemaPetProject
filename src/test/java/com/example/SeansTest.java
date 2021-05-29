package com.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class SeansTest extends TestCase {

    @Test
    @DisplayName("Seans Constructor should create seats in range #1 - #20")
    void shouldCreateProperAmountOfSeats() {
        Movie movie = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        Seans seans = new Seans(movie, LocalTime.of(16,0));

        Assertions.assertEquals(20, seans.getSeats().size());
    }

    @Test
    @DisplayName("Seans Constructor should create only free seats")
    void createdSeatsShouldBeFree() {
        Movie movie = new Movie("Name", LocalDate.of(2021, 1,1), "Description");
        Seans seans = new Seans(movie, LocalTime.of(16,0));

        for(Seat s: seans.getSeats()) {
            Assertions.assertTrue(s.isFree());
        }
    }

}