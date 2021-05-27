package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserSession session = greetUser();
        List<Movie> movieList = createMovies();
        List<CinemaSession> cinemaSessionList = createCinemaSessions(movieList);
        showMovies(session, movieList);
        List<CinemaSession> filteredCinemaSessionList = chooseMovie(cinemaSessionList);
        CinemaSession chosenCinemaSession = chooseCinemaSession(filteredCinemaSessionList);
        Ticket ticket = showAvailableSeatsAndChoose(chosenCinemaSession);
        session.getCurrentUser().purchaseTicket(ticket);
        // the next step is to offer user to purchase another ticket or go and watch a movie
    }

    public static UserSession greetUser() {
        System.out.println("Welcome to the command line Cinema" +
                "\nEnter your name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        User user = new User(userName);
        UserSession session = new UserSession();
        session.setCurrentUser(user);
        return session;
    }

    public static void showMovies(UserSession session, List<Movie> movieList) {
        System.out.println(session.getCurrentUser().getUserName() +
                " we happy to see you in Command line cinema." +
                "\nYou can watch next movies:\n");

        for(Movie movie: movieList) {
            System.out.println(movie);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------");
        }


    }

    public static  List<CinemaSession> chooseMovie(List<CinemaSession> cinemaSessionList) {
        System.out.println("Please enter name of the movie that you would like to watch:");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();

        cinemaSessionList.removeIf(cinemaSession -> !cinemaSession.getMovie().getMovieName().equals(movieName));

        return cinemaSessionList;
    }

    public static CinemaSession chooseCinemaSession(List<CinemaSession> cinemaSessionList) {
        System.out.println("Movie " + cinemaSessionList.get(0).getMovie().getMovieName() +
                " is available today at: ");
        int i = 1;
        // cinemaSessionList is need to be filtered:
        // cinemaSessions only with available seats should be displayed
        for(CinemaSession cinemaSession: cinemaSessionList) {
            System.out.print("#" + i + " " + cinemaSession.getTime() + "  ");
            i++;
        }

        System.out.println("Please enter number of cinemaSession: ");
        Scanner scanner = new Scanner(System.in);
        int cinemaSessionNumber = scanner.nextInt() - 1;

        return cinemaSessionList.get(cinemaSessionNumber);
    }

    public static Ticket showAvailableSeatsAndChoose(CinemaSession chosenCinemaSession) {
        System.out.println("Please choose available seats: ");
        for(Seat seat: chosenCinemaSession.getSeats()) {
            if(seat.isFree()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }

        Scanner scanner = new Scanner(System.in);
        int seatNumber = scanner.nextInt() - 1;

        chosenCinemaSession.getSeats().get(seatNumber).setFree(false);

        Ticket ticket = new Ticket(chosenCinemaSession, chosenCinemaSession.getSeats().get(seatNumber));

        return ticket;
    }

    private static List<Movie> createMovies() {
        Movie movieOne = new Movie(
                "ARMY OF THE DEAD",
                LocalDate.of(2021, 5, 14),
                "From filmmaker Zack Snyder (300, Zack Snyder's Justice League), " +
                        "\nARMY OF THE DEAD takes place following a zombie outbreak that has left " +
                        "\nLas Vegas in ruins and walled off from the rest of the world.");

        Movie movieTwo = new Movie(
                "THE WOMAN IN THE WINDOW",
                LocalDate.of(2021, 5, 14),
                "Anna Fox (Amy Adams) is an agoraphobic child psychologist who finds " +
                        "\nherself keeping tabs on the picture perfect family across the street " +
                        "\nthrough the windows of her New York City brownstone. Her life is turned " +
                        "\nupside down when she inadvertently witnesses a brutal crime. ");

        Movie movieThree = new Movie("THE MITCHELLS VS. THE MACHINES",
                LocalDate.of(2021, 4, 23),
                "Young Katie Mitchell embarks on a road trip with her proud parents, " +
                        "\nyounger brother and beloved dog to start her first year at film school. " +
                        "\nBut their plans to bond as a family soon get interrupted when the world's " +
                        "\nelectronic devices come to life to stage an uprising.");

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movieOne);
        movieList.add(movieTwo);
        movieList.add(movieThree);

        return movieList;
    }

    private static List<CinemaSession> createCinemaSessions(List<Movie> movieList) {
        List<CinemaSession> cinemaSessionList = new ArrayList<>();

        for(Movie movie: movieList) {
            cinemaSessionList.add(new CinemaSession(movie, LocalTime.of(12, 0)));
            cinemaSessionList.add(new CinemaSession(movie, LocalTime.of(15, 0)));
            cinemaSessionList.add(new CinemaSession(movie, LocalTime.of(18, 0)));
        }

        return cinemaSessionList;
    }
}
