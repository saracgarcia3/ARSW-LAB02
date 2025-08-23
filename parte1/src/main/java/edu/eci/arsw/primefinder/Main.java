package edu.eci.arsw.primefinder;

public class Main {

    public static void main(String[] args) {

        int limite = 100_000_000;
        int parte = limite / 3; 

        
        PrimeFinderThread hilo1 = new PrimeFinderThread(0, parte);
        PrimeFinderThread hilo2 = new PrimeFinderThread(parte, 2 * parte);
        PrimeFinderThread hilo3 = new PrimeFinderThread(2 * parte, limite);

        
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

}
