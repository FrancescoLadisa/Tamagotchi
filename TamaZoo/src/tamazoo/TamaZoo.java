package tamazoo;

import java.util.*;

public class TamaZoo {
	
	//ArrayList di Object per inserimento di più specie di Tamagotchi
	private ArrayList<Tamagotchi> tamazoo;
	
	public TamaZoo() {
		this.tamazoo = new ArrayList<>();
	}
	
	public void aggiungiTama(Tamagotchi tamagotchi) {
		tamazoo.add(tamagotchi);
	}
	
	public int numeroTama() {
		return tamazoo.size();
	}
	
	public Tamagotchi tamagotchi(int i) {
		return tamazoo.get(i);
	}
	
	private void rimuoviTama(Tamagotchi tamagotchi) {
		tamazoo.remove(tamagotchi);
	}
	
	private void controllaMorte(Tamagotchi tamagotchi) {
		
		boolean morto = tamagotchi.controllaMorte();
		
		if(morto) {
			rimuoviTama(tamagotchi);
		}
		
	}
	
	//Visualizzazione dei Tamagotchi presenti nello zoo
	public void visualizzaLoZoo() {
		
		Tamagotchi tama;
		int dimensioni;
		
		dimensioni = tamazoo.size();
		
		for(int i=0;i<dimensioni;i++) {
			
			tama = (Tamagotchi) (tamazoo.get(i));
			System.out.println(tama.toString());
			
		}
		
		for(int i=0;i<dimensioni;i++) {
			
			tama = (Tamagotchi) (tamazoo.get(i));
			controllaMorte(tama);
			dimensioni = tamazoo.size();
			System.out.println(dimensioni);
		}
		
	}
	
}
