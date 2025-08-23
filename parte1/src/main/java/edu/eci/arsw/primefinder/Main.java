package edu.eci.arsw.primefinder;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pft=new PrimeFinderThread(0, 100_000_000);
		
		pft.start();
		
		
	}
	
}
