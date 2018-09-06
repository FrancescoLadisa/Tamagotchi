package tamazoo;


public class Tamagotchi {
	
	private String nome;						//Nome del Tamagotchi
	
	private int numeroCarezze;					//Numero delle carezze date dall'utente
	private int numeroBiscotti;					//Numero dei biscotti dati in pasto	
	
	private static final int MINIMO = 0;		//Valori raggiunti i quali il Tamagotchi muore
	private static final int MASSIMO = 100;		
	
	private int gradoSoddisfazione;				//Grado di soddisfazione
	private int gradoSazieta;					//Grado di sazietà
	
	private static final String mortoDelTutto = " e' morto";
	private static final String nomeTama = "Nome: ";
	private static final String specie = "Appartiene alla specie: Tamagotchi";
	private static final String sazieta = "Il livello di sazieta' e': ";
	private static final String soddisfazione = "Il livello di soddisfazione e': ";
	private static final String tamaInfelice = " e' infelice, dagli carezze o biscotti.";
	private static final String aCapo = "\n";
	
	public Tamagotchi(String _nome, int _gradoSoddisfazione, int _gradoSazieta) {
		
		this.nome = _nome;
		this.gradoSoddisfazione = _gradoSoddisfazione;
		this.gradoSazieta = _gradoSazieta;
		
	}
	
	
	public void riceviCarezze(int _numeroCarezze) {
		
		this.numeroCarezze = _numeroCarezze;
		int controllo;
		controllo = numeroCarezze + gradoSoddisfazione;
		
		if(gradoSoddisfazione > MINIMO && gradoSoddisfazione < MASSIMO && controllo < MASSIMO) {
			
			gradoSoddisfazione += numeroCarezze;
			gradoSazieta -= (numeroCarezze / 2);
			
		}
		
	}
	
	public void mangiaBiscotti(int _numeroBiscotti) {
		
		this.numeroBiscotti = _numeroBiscotti;
		int percentuale;
		percentuale = numeroBiscotti / 10;
		
		if(gradoSazieta > MINIMO && gradoSazieta < MASSIMO) {
			
			gradoSazieta += gradoSazieta * percentuale; //Aumenta del 10% il grado di sazieta precedente per ogni biscotto mangiato
			gradoSoddisfazione -= numeroBiscotti / 4; 	//Diminuisce di 1/4 il grado di soddisfazione precedente per ogni biscotto mangiato
			
		}
		
	}
	
	//Verifica che il Tamagotchi sia vivo
	public boolean controllaMorte() {
		
		boolean controllo = false;
		
		//Se il grado di soddisfazione raggiunge lo 0 allora muore
		if(gradoSoddisfazione <= MINIMO) {
			
			controllo = true;
			
		}
		
		//Se il grado di sazietà raggiunge lo 0 anche in questo caso muore
		if(gradoSazieta <= MINIMO) {
			
			controllo = true;
			
		}
		
		//Se ha mangiato troppo cibo per un valore MASSIMO >= 100 allora muore
		if(gradoSazieta >= MASSIMO) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
	//Controlla il livello di felcità
	public boolean controllaFelicita() {
		
		boolean controllo = false;
		
		if(gradoSoddisfazione < 30) {
			
			controllo = true;
			
		}
		
		else if(gradoSazieta < 30) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
	//Metodo per la visualizzazione dello stato del Tamagotchi
	public String toString() {
		
		String stato = null;
		boolean morto = false, infelice = false;
		
		morto = controllaMorte();
		infelice = controllaFelicita();
		
		if(morto && !infelice){
			stato = aCapo + nome + mortoDelTutto;
		}
		
		if(infelice && !morto) {
			stato = nome + tamaInfelice + aCapo + specie + aCapo + sazieta + gradoSazieta + aCapo 
					+ soddisfazione + gradoSoddisfazione + aCapo;
		}
		
		if(!morto && !infelice) {
			stato = nomeTama + nome + aCapo + specie + aCapo + sazieta + gradoSazieta + aCapo + 
					soddisfazione + gradoSoddisfazione + aCapo;
		}
		
		return stato;
		
	}
	
}
