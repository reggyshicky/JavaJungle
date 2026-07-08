package com.simplejavaapplication;

/**
 * SimpleClockApp
 * ----------------
 * Entry point for the Simple Clock Application assignment.
 *
 * It creates a shared Clock object, then starts two threads that operate
 * on it concurrently:
 *   1. An update thread (extends Thread) that keeps the clock's internal
 *      time value fresh in the background.
 *   2. A display thread (implements Runnable) that reads the value and
 *      prints it to the console in the format "HH:mm:ss dd-MM-yyyy".
 *
 * Thread priorities are set explicitly so the display thread is favoured
 * by the scheduler over the background updater, per the assignment's
 * timekeeping-precision requirement. Because Java's thread priorities are
 * only a scheduling hint (the exact effect is JVM/OS dependent), the
 * update interval is also kept short relative to the display interval so
 * that the printed time is always current.
 *
 * The demo runs for a fixed duration and then shuts both threads down
 * cleanly, illustrating the full thread life cycle: NEW -> RUNNABLE ->
 * (TIMED_WAITING while sleeping) -> RUNNABLE -> TERMINATED.
 */
public class SimpleClockApp {

    private static final int UPDATE_INTERVAL_MS = 200;   // background refresh rate
    private static final int DISPLAY_INTERVAL_MS = 1000; // one printed line per second
    private static final int RUN_DURATION_MS = 12000;    // total demo run time

    public static void main(String[] args) {
        Clock clock = new Clock();

        ClockUpdateThread updateThread = new ClockUpdateThread(clock, UPDATE_INTERVAL_MS);

        ClockDisplayThread displayTask = new ClockDisplayThread(clock, DISPLAY_INTERVAL_MS);
        Thread displayThread = new Thread(displayTask, "DisplayThread");

        try {
            // Display thread gets the higher priority: it is the thread
            // whose timeliness the user actually sees.
            displayThread.setPriority(Thread.MAX_PRIORITY);
            updateThread.setPriority(Thread.MIN_PRIORITY);
        } catch (IllegalArgumentException e) {
            // setPriority throws if given a value outside 1-10; guard
            // against that even though MAX_PRIORITY/MIN_PRIORITY are always valid.
            System.err.println("Could not set thread priority: " + e.getMessage());
        }

        System.out.println("Starting Simple Clock Application...");
        System.out.println("Display thread priority: " + displayThread.getPriority());
        System.out.println("Update thread priority : " + updateThread.getPriority());
        System.out.println("----------------------------------------------------");

        updateThread.start();
        displayThread.start();

        // Lets the clock run for a fixed demo period, then shut it down
        // cleanly instead of killing the threads abruptly.
        try {
            Thread.sleep(RUN_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted while running the clock.");
        }

        updateThread.stopRunning();
        displayTask.stopRunning();

        try {
            // join() waits for each worker thread to reach the TERMINATED
            // state before the application exits.
            updateThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted while waiting for workers to stop.");
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Simple Clock Application has shut down.");
    }
}

