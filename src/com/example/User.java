package com.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userName;
    List<Ticket> userTickets;

    public User(String userName) {
        this.userName = userName;
        userTickets = new ArrayList<>();
    }

    public boolean purchaseTicket(Ticket ticket) {
        if(ticket == null || userTickets.contains(ticket)) {
            return false;
        }
        userTickets.add(ticket);
        System.out.println("You successfully purchased a ticket: " +
                "\nmovie: " + ticket.getCinemaSession().getMovie().getMovieName() +
                "\ntime: " + ticket.getCinemaSession().getTime() +
                "\nseat: " + ticket.getSeat().getSeatNumber());
        return true;
    }

    public String getUserName() {
        return userName;
    }
}
