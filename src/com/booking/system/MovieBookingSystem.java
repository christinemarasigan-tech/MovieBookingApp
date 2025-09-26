package com.booking.system;

import java.util.HashMap;
import java.util.Map;

/**
 * A concrete implementation of {@link BookingSystem} for managing
 * movie ticket reservations. Provides functionality to view shows,
 * check availability, book tickets, and cancel reservations.
 */
public class MovieBookingSystem extends BookingSystem {

    /**
     * Stores available show times and their remaining ticket counts.
     * Key: show time (e.g., "10:00 AM").
     * Value: number of tickets still available.
     */
    private Map<String, Integer> showTimes;

    /**
     * The default number of tickets available for each show.
     */
    private static final int TOTAL_TICKETS_PER_SHOW = 50;

    /**
   * Constants used in the main method for demonstration purposes.
   * These replace magic numbers to improve readability and comply
   * with Checkstyle rules.
   */
  // Constants for demo usage (avoid magic numbers in main)
  private static final int DEMO_BOOK_TICKETS_5 = 5;

  /** Number of tickets used for a large booking demo case. */
  private static final int DEMO_BOOK_TICKETS_100 = 100;

  /** Number of tickets used for a small booking demo case. */
  private static final int DEMO_BOOK_TICKETS_2 = 2;

  /** Number of tickets canceled in a demo case. */
  private static final int DEMO_CANCEL_TICKETS_3 = 3;

  /** Number of tickets canceled in another demo case. */
  private static final int DEMO_CANCEL_TICKETS_5 = 5;




    /**
     * Creates a new movie booking system with predefined show times
     * and default ticket counts.
     */
    public MovieBookingSystem() {
        showTimes = new HashMap<>();
        showTimes.put("10:00 AM", TOTAL_TICKETS_PER_SHOW);
        showTimes.put("1:00 PM", TOTAL_TICKETS_PER_SHOW);
        showTimes.put("4:00 PM", TOTAL_TICKETS_PER_SHOW);
        showTimes.put("7:00 PM", TOTAL_TICKETS_PER_SHOW);
    }

    /**
     * Displays the list of available shows along with the number of
     * tickets remaining for each show.
     */
    public void viewShows() {
        System.out.println("\nAvailable Shows and Tickets:");
        for (String showTime : showTimes.keySet()) {
            System.out.println(
                showTime + " - " + showTimes.get(showTime)
                + " tickets available"
            );
        }
        System.out.println();
    }

    /**
     * Checks if tickets are available for the given show time.
     *
     * @param showTime the show time (e.g., "10:00 AM")
     * @return {@code true} if tickets are available,
     *         {@code false} otherwise
     */
    @Override
    public final boolean checkAvailability(final String showTime) {
        return showTimes.containsKey(showTime) && showTimes.get(showTime) > 0;
    }

    /**
     * Attempts to book the specified number of tickets for a show time.
     *
     * @param showTime the show time (e.g., "10:00 AM")
     * @param tickets  number of tickets to book
     * @return {@code true} if booking is successful,
     *         {@code false} otherwise
     */
    @Override
    public final boolean bookTicket(final String showTime, final int tickets) {
        if (!showTimes.containsKey(showTime)) {
            System.out.println("Showtime not found: " + showTime);
            return false;
        }

        int availableTickets = showTimes.get(showTime);

        if (tickets <= 0) {
            System.out.println("Invalid ticket number: " + tickets);
            return false;
        }

        if (tickets > availableTickets) {
            System.out.println(
                "Not enough tickets available for " + showTime
            );
            return false;
        }

        showTimes.put(showTime, availableTickets - tickets);
        System.out.println(
            tickets + " tickets successfully booked for " + showTime
        );
        return true;
    }

    /**
     * Cancels a reservation for the specified number of tickets.
     *
     * @param showTime the show time (e.g., "10:00 AM")
     * @param tickets  number of tickets to cancel
     * @return {@code true} if cancellation is successful,
     *         {@code false} otherwise
     */
    @Override
    public final boolean cancelReservation(
        final String showTime, final int tickets
    ) {
        if (!showTimes.containsKey(showTime)) {
            System.out.println("Showtime not found: " + showTime);
            return false;
        }

        int availableTickets = showTimes.get(showTime);
        int bookedTickets = TOTAL_TICKETS_PER_SHOW - availableTickets;

        if (tickets <= 0) {
            System.out.println("Invalid ticket number: " + tickets);
            return false;
        }

        if (tickets > bookedTickets) {
            System.out.println(
                "Invalid operation: Attempt to cancel more tickets "
                + "than booked"
            );
            return false;
        }

        showTimes.put(showTime, availableTickets + tickets);
        System.out.println(
            tickets + " tickets successfully cancelled for " + showTime
        );
        return true;
    }

    /**
     * Main method to demonstrate the booking system.
     * Includes examples of booking and canceling tickets.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        MovieBookingSystem bookingSystem = new MovieBookingSystem();

        // View shows
        bookingSystem.viewShows();

        // Book tickets
        bookingSystem.bookTicket("10:00 AM", DEMO_BOOK_TICKETS_5);
        bookingSystem.bookTicket("1:00 PM", DEMO_BOOK_TICKETS_100);
        bookingSystem.bookTicket("1:00 PM", DEMO_BOOK_TICKETS_2);

        // Cancel tickets
        bookingSystem.cancelReservation("10:00 AM", DEMO_CANCEL_TICKETS_3);
        bookingSystem.cancelReservation("1:00 PM", DEMO_CANCEL_TICKETS_5);

        // View updated shows
        bookingSystem.viewShows();
    }
}


