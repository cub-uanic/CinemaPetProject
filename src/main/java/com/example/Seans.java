package com.example;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// rename
public class Seans {
    private Movie movie;
    private LocalTime time;
    private List<Seat> seats;

    public Seans(Movie movie, LocalTime time) {
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();
        for(int i=1; i<=20; i++) {
            try{
                seats.add(new Seat(i));
            } catch (Exception e) {
                System.out.println(e);
            }
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
        return "Seans{" +
                "movie=" + movie +
                ", time=" + time +
                ", seats=" + seats +
                '}';
    }
}
