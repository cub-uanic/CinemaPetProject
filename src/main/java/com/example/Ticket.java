package com.example;

public class Ticket {
    private com.example.Seans seans;
    private com.example.Seat seat;

    public Ticket(com.example.Seans seans, com.example.Seat seat) {
        this.seans = seans;
        this.seat = seat;
    }

    public com.example.Seans getCinemaSession() {
        return seans;
    }

    public com.example.Seat getSeat() {
        return seat;
    }
}
