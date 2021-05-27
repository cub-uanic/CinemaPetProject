package com.example;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaSession {
    private Movie movie;
    private LocalTime time;
    private List<Seat> seats;

    public CinemaSession(Movie movie, LocalTime time) {
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();
        for(int i=1; i<=20; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "CinemaSession{" +
                "movie=" + movie +
                ", time=" + time +
                ", seats=" + seats +
                '}';
    }
}
