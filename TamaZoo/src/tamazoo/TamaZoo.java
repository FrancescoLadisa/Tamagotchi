package tamazoo;

import java.util.*;

public class TamaZoo {
	
	//ArrayList di Object per inserimento di più specie di Tamagotchi
	private ArrayList<Object> tamazoo;	
	
	//Tamagotchi Standard
	private Tamagotchi tamagotchi;
	
	public TamaZoo() {
		this.tamazoo = new ArrayList<>();
	}
	
	public void creaTamagotchi(String _nome, int _gradoSoddisfazione, int _gradoSazieta) {
		
		this.tamagotchi = new Tamagotchi(_nome, _gradoSoddisfazione, _gradoSazieta);
		
		
	}
	
}
