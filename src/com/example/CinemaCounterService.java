package com.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CinemaCounterService {
    public User greetUser() {
        System.out.println("Welcome to the command line Cinema" +
                "\nEnter your name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        User user = new User(userName);
        System.out.println(user.getUserName() +
                " we happy to see you in Command line cinema.");
        return user;
    }

    public Movie chooseMovie(List<Movie> movies) {
        showMovies(movies);
        System.out.println("Please enter name of the movie that you would like to watch:");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        Movie movie = null;

        for(Movie m: movies) {
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

    public Seans chooseSeans(Movie movie, List<Seans> seansList) {
        System.out.println("Movie " + movie.getMovieName() +
                " is available today at: ");

        //    movieShowList.removeIf(movieShow -> !movieShow.getMovie().getMovieName().equals(movie.getMovieName()));
        // use equals for comparison
//        movieShowList.removeIf(movieShow -> movieShow.getMovie() != movie);
        // cinemaSessionList is need to be filtered:
        // cinemaSessions only with available seats should be displayed

        List<Seans> filteredSeansList = seansList.
                stream().
                filter(seans -> seans.getMovie().getMovieName().equals(movie.getMovieName())).
                collect(Collectors.toList());


        // use method filter from Collection
        int i = 1;
        for(Seans seans: filteredSeansList) {
            System.out.print("#" + i + " " + seans.getTime() + "  ");
            i++;
        }

        System.out.println("Please enter number of cinemaSession: ");
        Scanner scanner = new Scanner(System.in);
        int movieShowNumber = scanner.nextInt() - 1;

        return filteredSeansList.get(movieShowNumber);
    }

    public Seat chooseSeat(Seans chosenSeans) {
        System.out.println("Please choose available seats: ");
        showAvailableSeats(chosenSeans);

        Scanner scanner = new Scanner(System.in);
        int seatNumber = scanner.nextInt();

        return chosenSeans.getSeats().get(seatNumber - 1);
    }

    public Ticket createTicket(Seans chosenSeans, Seat chosenSeat) {
        chosenSeat.setFree(false);

        return new Ticket(chosenSeans, chosenSeat);
    }







    private static void showMovies(List<Movie> movieList) {
        System.out.println("You can watch next movies:\n");

        for(Movie movie: movieList) {
            System.out.println(movie);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------");
        }
        System.out.println();


    }

    private void showAvailableSeats(Seans chosenSeans) {
        for(Seat seat: chosenSeans.getSeats()) {
            if(seat.isFree()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
    }
}
