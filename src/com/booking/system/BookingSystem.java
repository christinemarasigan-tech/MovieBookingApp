package com.booking.system;

/**
 * Abstract class representing a generic booking system.
 * Provides methods for checking availability, booking tickets,
 * and canceling reservations.
 */
public abstract class BookingSystem {

    /**
     * Checks if tickets are available for the given show time.
     *
     * @param showTime the time of the show (e.g., "10:00 AM")
     * @return {@code true} if tickets are available,
     *         {@code false} otherwise
     */
    public abstract boolean checkAvailability(String showTime);

    /**
     * Attempts to book the specified number of tickets.
     *
     * @param showTime the time of the show (e.g., "10:00 AM")
     * @param tickets  the number of tickets to book
     * @return {@code true} if the booking was successful,
     *         {@code false} otherwise
     */
    public abstract boolean bookTicket(String showTime, int tickets);

    /**
     * Cancels a reservation for the given number of tickets.
     *
     * @param showTime the time of the show (e.g., "10:00 AM")
     * @param tickets  the number of tickets to cancel
     * @return {@code true} if the cancellation was successful,
     *         {@code false} otherwise
     */
    public abstract boolean cancelReservation(String showTime, int tickets);
}


