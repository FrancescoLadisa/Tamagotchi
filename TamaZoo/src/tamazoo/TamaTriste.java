package tamazoo;

public class TamaTriste extends Tamagotchi{
	
	private String nome;						//Nome del Tamagotchi
	
	private int numeroBiscotti;					//Numero dei biscotti dati in pasto	
	
	private static final int MINIMO = 0;		//Valori raggiunti i quali il Tamagotchi muore
	private static final int MASSIMO = 100;		
	
	private int gradoSoddisfazione = 0;			//Grado di soddisfazione sempre a 0, infelice
	private int gradoSazieta;					//Grado di sazietà
	
	private static final String mortoDelTutto = " e' morto";
	private static final String nomeTama = "Nome: ";
	private static final String sazieta = "Il livello di sazieta' e': ";
	private static final String specie = "Appartiene alla specie: TamaTriste";
	private static final String soddisfazione = "Il livello di soddisfazione e': ";
	private static final String aCapo = "\n";
	
	public TamaTriste(String _nome, int _gradoSoddisfazione, int _gradoSazieta) {
		
		super(_nome, _gradoSoddisfazione, _gradoSazieta);
		this.nome = _nome;
		this.gradoSoddisfazione = _gradoSoddisfazione;
		this.gradoSazieta = _gradoSazieta;
		
	}
	
	public void mangiaBiscotti(int _numeroBiscotti) {
		
		this.numeroBiscotti = _numeroBiscotti;
		int percentuale = numeroBiscotti / 10;
		gradoSazieta += gradoSazieta * percentuale; //Aumenta del 10% il grado di sazieta precedente per ogni biscotto mangiato
		
	}
	
	//Verifica che il Tamagotchi sia vivo
	public boolean controllaMorte() {
		
		boolean controllo = false;
		
		//Se il grado di sazietà raggiunge lo 0 anche in questo caso muore e se
		//ha mangiato troppo cibo per un valore MASSIMO >= 100 allora muore
		if(gradoSazieta <= MINIMO || gradoSazieta >= MASSIMO) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
	//Visualizza lo stato del Tamatriste
	public String toString() {
		
		boolean morto = controllaMorte();
		
		if(morto) {
			return aCapo + nomeTama + nome + mortoDelTutto;
		}
		else {
			return aCapo + nomeTama + nome + aCapo + specie + aCapo + sazieta 
				   + gradoSazieta + aCapo + soddisfazione + gradoSoddisfazione + aCapo;
		}
		
	}
	
}
