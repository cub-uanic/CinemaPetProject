package com.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CinemaCounterService {
    public com.example.User greetUser() {
        System.out.println("Welcome to the command line Cinema" +
                "\nEnter your name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        com.example.User user = new com.example.User(userName);
        System.out.println(user.getUserName() +
                " we happy to see you in Command line cinema.");
        return user;
    }

    public com.example.Movie chooseMovie(List<com.example.Movie> movies) {
        showMovies(movies);
        System.out.println("Please enter name of the movie that you would like to watch:");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        com.example.Movie movie = null;

        for(com.example.Movie m: movies) {
            if(m.getMovieName().equals(movieName)) {
                movie = m;
            }
        }

        if(movie == null) {
            System.out.println("Entered movie name wasn't found in the list.");
            chooseMovie(movies);
        }

        return movie;
    }

    public com.example.Seans chooseSeans(com.example.Movie movie, List<com.example.Seans> seansList) {
        System.out.println("Movie " + movie.getMovieName() +
                " is available today at: ");

        //    movieShowList.removeIf(movieShow -> !movieShow.getMovie().getMovieName().equals(movie.getMovieName()));
        // use equals for comparison
//        movieShowList.removeIf(movieShow -> movieShow.getMovie() != movie);
        // cinemaSessionList is need to be filtered:
        // cinemaSessions only with available seats should be displayed

        List<com.example.Seans> filteredSeansList = seansList.
                stream().
                filter(seans -> seans.getMovie().getMovieName().equals(movie.getMovieName())).
                collect(Collectors.toList());


        // use method filter from Collection
        int i = 1;
        for(com.example.Seans seans: filteredSeansList) {
            System.out.print("#" + i + " " + seans.getTime() + "  ");
            i++;
        }

        System.out.println("Please enter number of cinemaSession: ");
        Scanner scanner = new Scanner(System.in);
        int movieShowNumber = scanner.nextInt() - 1;

        return filteredSeansList.get(movieShowNumber);
    }

    public com.example.Seat chooseSeat(com.example.Seans chosenSeans) {
        System.out.println("Please choose available seats: ");
        showAvailableSeats(chosenSeans);

        Scanner scanner = new Scanner(System.in);
        int seatNumber = scanner.nextInt();

        return chosenSeans.getSeats().get(seatNumber - 1);
    }

    public com.example.Ticket createTicket(com.example.Seans chosenSeans, com.example.Seat chosenSeat) {
        chosenSeat.setFree(false);

        return new com.example.Ticket(chosenSeans, chosenSeat);
    }







    private static void showMovies(List<com.example.Movie> movieList) {
        System.out.println("You can watch next movies:\n");

        for(com.example.Movie movie: movieList) {
            System.out.println(movie);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------");
        }
        System.out.println();


    }

    private void showAvailableSeats(com.example.Seans chosenSeans) {
        for(com.example.Seat seat: chosenSeans.getSeats()) {
            if(seat.isFree()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
    }
}
