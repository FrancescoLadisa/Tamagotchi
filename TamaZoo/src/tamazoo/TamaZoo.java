package tamazoo;

import java.util.*;

public class TamaZoo {
	
	//ArrayList di Object per inserimento di più specie di Tamagotchi
	private ArrayList<Object> tamazoo;
	
	public TamaZoo() {
		this.tamazoo = new ArrayList<>();
	}
	
	public void aggiungiTama(Object tamagotchi) {
		
		tamazoo.add(tamagotchi);
		
	}
	
	public void rimuoviTama(Object tamagotchi) {
		
		tamazoo.remove(tamagotchi);
		
	}
	
	//Visualizzazione dei Tamagotchi presenti nello zoo
	public void visualizzaLoZoo() {
		
		for(int i=0;i<tamazoo.size();i++) {
			
			System.out.println(tamazoo.get(i));
			
		}
		
	}
	
}
