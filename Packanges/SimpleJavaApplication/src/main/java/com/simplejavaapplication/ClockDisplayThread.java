package com.simplejavaapplication;

/**
 * ClockDisplayThread is the worker responsible for printing the current
 * time to the console at a steady pace. It implements Runnable rather
 * than extending Thread, showing the second standard way of defining a
 * Java thread's task (the first is used by ClockUpdateThread).
 *
 * This thread is given a HIGHER priority than the update thread, per the
 * assignment requirement, because timely, on-schedule printing is what the
 * user actually perceives as "clock precision" - a delayed print looks
 * like a stuttering clock even if the underlying time value is accurate.
 */
public class ClockDisplayThread implements Runnable {

    private final Clock clock;
    private final int displayIntervalMillis;

    private volatile boolean running = true;

    public ClockDisplayThread(Clock clock, int displayIntervalMillis) {
        this.clock = clock;
        this.displayIntervalMillis = displayIntervalMillis;
    }

    public void stopRunning() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                clock.displayCurrentTime();
                Thread.sleep(displayIntervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }
}

