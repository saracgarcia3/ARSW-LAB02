package edu.eci.arsw.primefinder;

public class PauseController {
    private boolean paused = false;

    public synchronized void pause() {
        paused = true;
    }

    public synchronized void resumeAll() {
        paused = false;
        notifyAll();
    }

    public synchronized void awaitIfPaused() {
        while (paused) {
            try {
                wait();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public synchronized boolean isPaused() {
        return paused;
    }
}
