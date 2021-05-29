package com.example;

import java.util.HashMap;
import java.util.Map;

public class Seat {
    private int seatNumber;
    private boolean isFree;

    public Seat(int seatNumber) throws Exception {
        if(seatNumber < 1 || seatNumber > 20) {
            System.out.println("Invalid seat number");
            throw new Exception("Invalid seat number");
        }
        this.seatNumber = seatNumber;
        this.isFree = true;

    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
