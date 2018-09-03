package tamazoo;

public class TamaTriste extends Tamagotchi{
	
	private String nome;						//Nome del Tamagotchi
	
	private int numeroCarezze;					//Numero delle carezze date dall'utente
	private int numeroBiscotti;					//Numero dei biscotti dati in pasto	
	
	private static final int MINIMO = 0;		//Valori raggiunti i quali il Tamagotchi muore
	private static final int MASSIMO = 100;		
	
	private int gradoSoddisfazione = 0;			//Grado di soddisfazione sempre a 0, infelice
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
	
	public TamaTriste(String _nome, int _gradoSoddisfazione, int _gradoSazieta) {
		super(_nome, _gradoSoddisfazione, _gradoSazieta);
	}
	
	public void mangiaBiscotti(int _numeroBiscotti) {
		
		this.numeroBiscotti = _numeroBiscotti;
		int percentuale = numeroBiscotti / 10;
		gradoSazieta += gradoSazieta * percentuale; //Aumenta del 10% il grado di sazieta precedente per ogni biscotto mangiato
		
	}
	
	//Verifica che il Tamagotchi sia vivo
	public boolean controllaMorte() {
		
		boolean controllo = false;
		
		//Se il grado di sazietà raggiunge lo 0 anche in questo caso muore
		if(gradoSazieta == MINIMO) {
			
			controllo = true;
			
		}
		
		//Se ha mangiato troppo cibo per un valore MASSIMO >= 100 allora muore
		if(gradoSazieta >= MASSIMO) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
}
