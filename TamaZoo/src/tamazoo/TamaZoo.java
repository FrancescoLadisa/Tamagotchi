package tamazoo;

import java.util.*;

public class TamaZoo {
	
	//ArrayList di Object per inserimento di più specie di Tamagotchi
	private ArrayList<Object> tamazoo;
	
	public TamaZoo() {
		this.tamazoo = new ArrayList<>();
	}
	
	//Visualizzazione dei Tamagotchi presenti nello zoo
	public void visualizzaLoZoo() {
		
		Tamagotchi tama;
		
		for(int i=0;i<tamazoo.size();i++) {
			
			tama = (Tamagotchi)(tamazoo.get(i));
			tama.visualizzaStato();
			
		}
		
	}
	
}
