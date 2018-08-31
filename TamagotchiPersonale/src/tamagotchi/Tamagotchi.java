package tamagotchi;


public class Tamagotchi {
	
	private String nome;						//Nome del Tamagotchi
	
	private int numeroCarezze;					//Numero delle carezze date dall'utente
	private int numeroBiscotti;					//Numero dei biscotti dati in pasto	
	
	private static final int MINIMO = 0;		//Valori raggiunti i quali il Tamagotchi muore
	private static final int MASSIMO = 100;		
	
	private int gradoSoddisfazione;				//Grado di soddisfazione
	private int gradoSazieta;					//Grado di sazietà
	
	private static final String mortoNoAffetto = " e' morto per mancanza di affetto";
	private static final String mortoNoCibo = " e' morto di fame";
	private static final String mortoTroppoCibo = " e' morto perche' gli hai dato troppi biscotti";
	private static final String mortoDelTutto = "Il tuo Tamagotchi e' morto malissimo";
	private static final String nomeTama = "Il Tamagotchi creato si chiama: ";
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
		int controllo = numeroCarezze + gradoSoddisfazione;
		
		if(gradoSoddisfazione > MINIMO && gradoSoddisfazione < MASSIMO && controllo < MASSIMO) {
			
			gradoSoddisfazione += numeroCarezze;
			gradoSazieta -= (numeroCarezze / 2);
			
		}
		
	}
	
	public void mangiaBiscotti(int _numeroBiscotti) {
		
		this.numeroBiscotti = _numeroBiscotti;
		int percentuale = numeroBiscotti / 10;
		
		if(gradoSazieta > MINIMO && gradoSazieta < MASSIMO) {
			
			gradoSazieta += gradoSazieta * percentuale; //Aumenta del 10% il grado di sazieta precedente per ogni biscotto mangiato
			gradoSoddisfazione -= numeroBiscotti / 4; 	//Diminuisce di 1/4 il grado di soddisfazione precedente per ogni biscotto mangiato
			
		}
		
	}
	
	//Verifica che il Tamagotchi sia vivo
	public boolean controllaMorte() {
		
		boolean controllo = false;
		
		//Se il grado di soddisfazione raggiunge lo 0 allora muore
		if(gradoSoddisfazione == MINIMO) {
			
			controllo = true;
			System.out.println(nome+mortoNoAffetto);
			
		}
		
		//Se il grado di sazietà raggiunge lo 0 anche in questo caso muore
		if(gradoSazieta == MINIMO) {
			
			controllo = true;
			System.out.println(nome+mortoNoCibo);
			
		}
		
		//Se ha mangiato troppo cibo per un valore MASSIMO >= 100 allora muore
		if(gradoSazieta >= MASSIMO) {
			
			controllo = true;
			System.out.println(nome+mortoTroppoCibo);
			
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
	public String visualizzaStato() {
		
		String stato = null;
		boolean morto = false, infelice = false;
		
		morto = controllaMorte();
		infelice = controllaFelicita();
		
		if(morto){    
			
			stato = nome + mortoDelTutto + aCapo + sazieta + gradoSazieta + aCapo + soddisfazione + gradoSoddisfazione + aCapo;
			return stato;
			
		}
		if(infelice) {
			
			stato = nome + tamaInfelice + aCapo + sazieta + gradoSazieta + aCapo + soddisfazione + gradoSoddisfazione + aCapo;
			return stato;
		
		}
		if(!morto && !infelice) {
			
			stato = nomeTama + nome + aCapo + sazieta + gradoSazieta + aCapo + soddisfazione + gradoSoddisfazione + aCapo;
			return stato;
			
		}
		
		return null;
		
	}
	
}
