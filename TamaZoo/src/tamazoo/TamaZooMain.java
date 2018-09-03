package tamazoo;

import it.unibs.fp.mylib.*;

public class TamaZooMain {

	private static final String saluto = "Benvenuto a Tamagotchi Land";
	private static final String crea = "Crea il tuo Tamagotchi personale, dovrai inserire il nome qui di seguito: ";
	private static final String gradoDiSoddisfazione = "Inserisci il grado iniziale di soddisfazione (compreso tra 1 e 99): ";
	private static final String gradoDiSazieta = "Inserisci il grado iniziale di sazieta' (anche in questo caso, compreso tra 1 e 99): ";
	private static final String carezzeBiscotti = "Vuoi dare al Tamagotchi delle carezze o dei biscotti? ";
	private static final String numeroBiscotti = "Numero dei biscotti che gli stai dando: ";
	private static final String numeroCarezze = "Numero delle carezze che gli stai dando: ";
	private static final String aCapo = "\n";
	
	private static final int MINIMO = 1;
	private static final int MASSIMO = 99;
	
	public static void main(String[] args) {
		
		Tamagotchi tamagotchi;
		
		String scelta, stato;
		boolean morto = false, infelice = false;
		int gradoSoddisfazione;
		int gradoSazieta;
		int random;
		
		System.out.println(saluto+aCapo);
		
		//Input dei dati iniziali
		String nome = InputDati.leggiStringaNonVuota(crea);
		gradoSoddisfazione = InputDati.leggiIntero(gradoDiSoddisfazione, MINIMO, MASSIMO);
		gradoSazieta = InputDati.leggiIntero(gradoDiSazieta, MINIMO, MASSIMO);
		
		//Creazione del Tamagotchi
		tamagotchi = new Tamagotchi(nome, gradoSoddisfazione, gradoSazieta);
		stato = tamagotchi.visualizzaStato();
		System.out.println(stato);
		
		while(!morto) {
			
			scelta = InputDati.leggiStringaNonVuota(carezzeBiscotti);
			random = NumeriCasuali.estraiIntero(MINIMO, MASSIMO);
			
			switch(scelta) {
				
				case "carezze": System.out.println(numeroCarezze + random);
								tamagotchi.riceviCarezze(random);
								morto = tamagotchi.controllaMorte();
								if(morto) {
									System.exit(0);
								}
								else {
									stato = tamagotchi.visualizzaStato();
									System.out.println(stato);
								}
								break;
				case "biscotti": System.out.println(numeroBiscotti + random);
								 tamagotchi.mangiaBiscotti(random);
								 morto = tamagotchi.controllaMorte();
								 if(morto) {
								  	System.exit(0);
								 } 
								 else {
									stato = tamagotchi.visualizzaStato();
									System.out.println(stato);
								}
								break;
				case "esci": break;
				default: break;
			}
			
		}
		
	}

}
