package com.simplejavaapplication;

/**
 * ClockUpdateThread is the background worker that keeps the Clock's
 * internal time value fresh. It runs at a LOWER priority than the display
 * thread, since correctness only requires that the value be refreshed
 * often enough for the display thread to see up-to-date data - it is not
 * critical that this thread win every scheduling contest.
 *
 * This thread extends Thread directly, one of the two standard ways of
 * creating a Java thread (the other, used by ClockDisplayThread, is
 * implementing Runnable).
 */
public class ClockUpdateThread extends Thread {

    private final Clock clock;
    private final int updateIntervalMillis;

    // Shared shutdown flag, checked on every loop iteration so the thread
    // can be stopped cleanly instead of being killed abruptly.
    private volatile boolean running = true;

    public ClockUpdateThread(Clock clock, int updateIntervalMillis) {
        super("UpdateThread");
        this.clock = clock;
        this.updateIntervalMillis = updateIntervalMillis;
    }

    /** Signals the thread to stop after its current iteration. */
    public void stopRunning() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                clock.updateCurrentTime();
                Thread.sleep(updateIntervalMillis);
            } catch (InterruptedException e) {
                // Preserve the interrupt status and exit the loop cleanly
                // rather than swallowing the exception.
                Thread.currentThread().interrupt();
                running = false;
            }
        }
        System.out.println(getName() + " has stopped.");
    }
}

