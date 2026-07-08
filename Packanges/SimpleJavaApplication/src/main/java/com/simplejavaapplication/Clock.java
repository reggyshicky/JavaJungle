package com.simplejavaapplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clock represents the shared state of the application: the current
 * date/time value. Two threads act on this object concurrently:
 *   - a background thread that keeps refreshing the internal time value
 *   - a display thread that reads the value and prints it to the console
 *
 * The internal time reference is declared "volatile" so that a write made
 * by the background thread is always immediately visible to the display
 * thread, without needing a full synchronized block on every read. This is
 * safe here because LocalDateTime is immutable and there is exactly one
 * thread writing to the field.
 */
public class Clock {
    // Format required by the assignment: "HH:mm:ss dd-MM-yyyy"
    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    // Shared, continuously refreshed time value.
    private volatile LocalDateTime currentTime;

    public Clock() {
        this.currentTime = LocalDateTime.now();
    }

    /**
     * Refreshes the internal time value to "now".
     * Called repeatedly by the background updating thread.
     */
    public void updateCurrentTime() {
        this.currentTime = LocalDateTime.now();
    }

    /**
     * Formats and prints the current time to the console.
     * Called repeatedly by the display thread.
     */
    public void displayCurrentTime() {
        LocalDateTime snapshot = this.currentTime; // one volatile read, avoids tearing
        System.out.println(snapshot.format(TIME_FORMAT)
                + "  [printed by: " + Thread.currentThread().getName()
                + ", priority: " + Thread.currentThread().getPriority() + "]");
    }
}