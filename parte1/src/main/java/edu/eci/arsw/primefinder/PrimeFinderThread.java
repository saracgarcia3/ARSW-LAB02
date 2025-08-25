package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread {

    int a, b;

    private final List<Integer> primes = new LinkedList<>();
    private final Object primesLock = new Object();

    private final PauseController pauseController;

    public PrimeFinderThread(int a, int b, PauseController pauseController) {
        super();
        this.a = a;
        this.b = b;
        this.pauseController = pauseController;
    }

    @Override
    public void run() {
        for (int i = a; i <= b; i++) {
            pauseController.awaitIfPaused();

            if (isPrime(i)) {
                synchronized (primesLock) {
                    primes.add(i);
                }
                System.out.println(i);
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;           
        if (n == 2) return true;           
        if (n % 2 == 0) return false;
        for (int d = 3; d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public List<Integer> getPrimes() {
        synchronized (primesLock) {
            return new LinkedList<>(primes); 
        }
    }

    public int getCount() {
        synchronized (primesLock) {
            return primes.size();
        }
    }
}

