package com.example;

public class Ticket {
    private Seans seans;
    private Seat seat;

    public Ticket(Seans seans, Seat seat) {
        this.seans = seans;
        this.seat = seat;
    }

    public Seans getCinemaSession() {
        return seans;
    }

    public Seat getSeat() {
        return seat;
    }
}
