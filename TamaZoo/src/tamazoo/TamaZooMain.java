package tamazoo;

import it.unibs.fp.mylib.*;

public class TamaZooMain {

	private static final String saluto = "Benvenuto a Tamagotchi Land";
	private static final String crea = "Crea il tuo Tama Zoo personale, dovrai inserire il numero dei Tamagotchi da creare qui di seguito: ";
	private static final String inserireNome = "Inserisci il nome del Tamagotchi: ";
	private static final String gradoDiSoddisfazione = "Inserisci il grado iniziale di soddisfazione (compreso tra 1 e 99): ";
	private static final String gradoDiSazieta = "Inserisci il grado iniziale di sazieta' (anche in questo caso, compreso tra 1 e 99): ";
	private static final String carezzeBiscotti = "Vuoi dare al Tamagotchi delle carezze o dei biscotti? ";
	private static final String numeroBiscotti = "Numero dei biscotti che gli stai dando: ";
	private static final String numeroCarezze = "Numero delle carezze che gli stai dando: ";
	private static final String aCapo = "\n";
	
	private static final int MINIMO = 0;
	private static final int MASSIMO = 100;
	
	private static TamaZoo creaTamaZoo(int _numTama) {
		
		TamaZoo zoo = new TamaZoo();
		
		Tamagotchi tama;
		TamaTriste triste;
		TamaGordo ingordo;
		
		int specie, min = 1, max = 3, soddisfazioneIni, sazietaIni;
		
		for(int i=MINIMO;i<_numTama;i++) {
			
			//Scelta casuale della specie di tamagotchi
			specie = NumeriCasuali.estraiIntero(min, max);
			System.out.print("\nSpecie estratta: "+specie);
			String nome = InputDati.leggiStringaNonVuota(aCapo + inserireNome);
			
			switch(specie) {
			
				case 1:	soddisfazioneIni = NumeriCasuali.estraiIntero(MINIMO, MASSIMO);
						sazietaIni = NumeriCasuali.estraiIntero(MINIMO, MASSIMO);
						tama = new Tamagotchi(nome, soddisfazioneIni, sazietaIni);
						zoo.aggiungiTama(tama);
						break;
				case 2:	sazietaIni = NumeriCasuali.estraiIntero(MINIMO, MASSIMO);
						triste = new TamaTriste(nome, MINIMO, sazietaIni);
						zoo.aggiungiTama(triste);
						break;
				case 3:	sazietaIni = NumeriCasuali.estraiIntero(MINIMO, MASSIMO);
						ingordo = new TamaGordo(nome, MASSIMO, sazietaIni);
						zoo.aggiungiTama(ingordo);
						break;
				default:break;
			
			}
			
		}
		
		return zoo;
		
	}
	
	private static void visualizzaZoo(TamaZoo zoo) {
		
		zoo.visualizzaLoZoo();
		
	}
	
	public static void main(String[] args) {
		
		int numTama;
		int minimo = 1, massimo = 15;
		
		//Input dei dati iniziali
		numTama = InputDati.leggiIntero(saluto+aCapo+crea, minimo, massimo);
		
		//Creazione del TamaZoo
		TamaZoo zoo = creaTamaZoo(numTama);
		
		
		//Visualizzazione dello stato dello zoo
		visualizzaZoo(zoo);
		
	}

}
