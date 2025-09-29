
package com.booking.system;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the MovieBookingSystem class.
 * Code Reviewer: MarkSayson
 */
public class MovieBookingSystemTest {

    /** Instance of booking system used in all tests. */
    private MovieBookingSystem bookingSystem;

    // Constants to avoid magic numbers in tests
    /** Constant for booking 5 tickets. */
    private static final int BOOK_TICKETS_5 = 5;

    /** Constant for booking 100 tickets (overbooking test). */
    private static final int BOOK_TICKETS_100 = 100;

    /** Constant for booking 2 tickets. */
    private static final int BOOK_TICKETS_2 = 2;

    /** Constant for canceling 3 tickets. */
    private static final int CANCEL_TICKETS_3 = 3;

    /** Constant for canceling 5 tickets. */
    private static final int CANCEL_TICKETS_5 = 5;

    /** Constant for canceling negative tickets. */
    private static final int CANCEL_TICKETS_NEGATIVE = -3;

    /**
     * Initializes a fresh MovieBookingSystem before each test.
     */
    @BeforeEach
    public void setup() {
        bookingSystem = new MovieBookingSystem();
    }

    /** Test Case 1: Book 5 tickets for 10:00 AM. */
    @Test
    @DisplayName("Test Case 1: Book 5 tickets for 10:00 AM")
    public void testBookTicketSuccess() {
        // Act
        boolean result = bookingSystem.bookTicket("10:00 AM", BOOK_TICKETS_5);
        // Assert
        assertTrue(result);
    }

    /** Test Case 2: Book 100 tickets for 10:00 AM (too many). */
    @Test
    @DisplayName("Test Case 2: Book too many tickets for 10:00 AM")
    public void testBookTicketTooMany() {
        // Act
        boolean result = bookingSystem.bookTicket("10:00 AM", BOOK_TICKETS_100);
        // Assert
        assertFalse(result);
    }

    /** Test Case 3: Cancel 3 tickets for 10:00 AM. */
    @Test
    @DisplayName("Test Case 3: Cancel 3 tickets for 10:00 AM")
    public void testCancelReservationSuccess() {
        // Arrange
        bookingSystem.bookTicket("10:00 AM", BOOK_TICKETS_5);
        // Act
        boolean result =
            bookingSystem.cancelReservation("10:00 AM", CANCEL_TICKETS_3);
        // Assert
        assertTrue(result);
    }

    /** Test Case 4: Book 2 tickets for 1:00 PM. */
    @Test
    @DisplayName("Test Case 4: Book 2 tickets for 1:00 PM")
    public void testBookTicketsAnotherShow() {
        // Act
        boolean result = bookingSystem.bookTicket("1:00 PM", BOOK_TICKETS_2);
        // Assert
        assertTrue(result);
    }

    /** Test Case 5: Cancel 5 tickets for 1:00 PM (too many). */
    @Test
    @DisplayName("Test Case 5: Cancel too many tickets for 1:00 PM")
    public void testCancelReservationTooMany() {
        // Arrange
        bookingSystem.bookTicket("1:00 PM", BOOK_TICKETS_2);
        // Act
        boolean result =
            bookingSystem.cancelReservation("1:00 PM", CANCEL_TICKETS_5);
        // Assert
        assertFalse(result);
    }

    /** Test Case 6: Check availability for valid showtime. */
    @Test
    @DisplayName("Test Case 6: Check availability for valid showtime")
    public void testCheckAvailabilityValidShow() {
        // Act & Assert
        assertTrue(bookingSystem.checkAvailability("10:00 AM"));
    }

    /** Test Case 7: Check availability for invalid showtime. */
    @Test
    @DisplayName("Test Case 7: Check availability for invalid showtime")
    public void testCheckAvailabilityInvalidShow() {
        // Act & Assert
        assertFalse(bookingSystem.checkAvailability("11:00 PM"));
    }

    /** Test Case 8: Book tickets for invalid showtime. */
    @Test
    @DisplayName("Test Case 8: Book tickets for invalid showtime")
    public void testBookTicketInvalidShow() {
        // Act
        boolean result = bookingSystem.bookTicket("11:00 PM", BOOK_TICKETS_5);
        // Assert
        assertFalse(result);
    }

    /** Test Case 9: Book 0 tickets. */
    @Test
    @DisplayName("Test Case 9: Book 0 tickets")
    public void testBookTicketInvalidTicketsZero() {
        // Act
        boolean result = bookingSystem.bookTicket("10:00 AM", 0);
        // Assert
        assertFalse(result);
    }

    /** Test Case 10: Book negative tickets. */
    @Test
    @DisplayName("Test Case 10: Book negative tickets")
    public void testBookTicketInvalidTicketsNegative() {
        // Act
        boolean result = bookingSystem.bookTicket("10:00 AM", -BOOK_TICKETS_5);
        // Assert
        assertFalse(result);
    }

    /** Test Case 11: Cancel tickets for invalid showtime. */
    @Test
    @DisplayName("Test Case 11: Cancel tickets for invalid showtime")
    public void testCancelReservationInvalidShow() {
        // Act
        boolean result =
            bookingSystem.cancelReservation("11:00 PM", BOOK_TICKETS_2);
        // Assert
        assertFalse(result);
    }

    /** Test Case 12: Cancel 0 tickets. */
    @Test
    @DisplayName("Test Case 12: Cancel 0 tickets")
    public void testCancelReservationInvalidTicketsZero() {
        // Arrange
        bookingSystem.bookTicket("10:00 AM", BOOK_TICKETS_5);
        // Act
        boolean result = bookingSystem.cancelReservation("10:00 AM", 0);
        // Assert
        assertFalse(result);
    }

    /** Test Case 13: Cancel negative tickets. */
    @Test
    @DisplayName("Test Case 13: Cancel negative tickets")
    public void testCancelReservationInvalidTicketsNegative() {
        // Arrange
        bookingSystem.bookTicket("10:00 AM", BOOK_TICKETS_5);
        // Act
        boolean result =
            bookingSystem.cancelReservation("10:00 AM",
                                            CANCEL_TICKETS_NEGATIVE);
        // Assert
        assertFalse(result);
    }

    /** Test Case 14: Execute viewShows() and main(). */
    @Test
    @DisplayName("Test Case 14: Execute viewShows and main")
    public void testViewShowsAndMain() {
        // Act
        bookingSystem.viewShows();
        MovieBookingSystem.main(new String[]{});
        // Assert
        assertTrue(true);
    }
}

