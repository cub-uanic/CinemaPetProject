package com.example;

public class Ticket {
    private CinemaSession cinemaSession;
    private Seat seat;

    public Ticket(CinemaSession cinemaSession, Seat seat) {
        this.cinemaSession = cinemaSession;
        this.seat = seat;
    }

    public CinemaSession getCinemaSession() {
        return cinemaSession;
    }

    public Seat getSeat() {
        return seat;
    }
}
