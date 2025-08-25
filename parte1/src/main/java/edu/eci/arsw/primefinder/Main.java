package edu.eci.arsw.primefinder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        int limite = 100_000_000;
        int parte = limite / 3;

        PauseController pc = new PauseController();

        PrimeFinderThread hilo1 = new PrimeFinderThread(0, parte, pc);
        PrimeFinderThread hilo2 = new PrimeFinderThread(parte, 2 * parte, pc);
        PrimeFinderThread hilo3 = new PrimeFinderThread(2 * parte, limite, pc);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        Thread.sleep(5000);
        pc.pause();


        Thread.sleep(100);

        int encontrados = hilo1.getCount() + hilo2.getCount() + hilo3.getCount();
        System.out.println("\n=== PAUSA (5 s) ===");
        System.out.println("Primos encontrados hasta el momento: " + encontrados);
        System.out.println("Presiona ENTER para reanudar...");

        new BufferedReader(new InputStreamReader(System.in)).readLine();

        pc.resumeAll();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        int total = hilo1.getCount() + hilo2.getCount() + hilo3.getCount();
        System.out.println("\n=== TERMINADO ===");
        System.out.println("Total de primos: " + total);
    }
}

