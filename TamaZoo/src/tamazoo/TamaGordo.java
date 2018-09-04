package tamazoo;

public class TamaGordo extends Tamagotchi{
	
	private String nome;						//Nome del Tamagotchi
	
	private int numeroBiscotti;					//Numero dei biscotti dati in pasto	
	
	private static final int MINIMO = 0;		//Valore raggiunto il quale il Tamagotchi muore
	
	private int gradoSoddisfazione = 100;		//Grado di soddisfazione sempre a 100, felice
	private int gradoSazieta;					//Grado di sazietà
	
	private static final String mortoNoCibo = " e' morto di fame";
	private static final String nomeTama = "Il Tamagotchi creato si chiama: ";
	private static final String specie = "Appartiene alla specie: TamaGordo";
	private static final String sazieta = "Il livello di sazieta' e': ";
	private static final String soddisfazione = "Il livello di soddisfazione e': ";
	private static final String tamaInfelice = " e' infelice, dagli biscotti.";
	private static final String aCapo = "\n";
	
	public TamaGordo(String _nome, int _gradoSoddisfazione, int _gradoSazieta) {
		super(_nome, _gradoSoddisfazione, _gradoSazieta);
	}
	
	//Il tamagordo mangia solo i biscotti, se ne mangia pochi e 
	//riceve troppe carezze allora muore 
	@Override
	public void mangiaBiscotti(int _numeroBiscotti) {
		
		this.numeroBiscotti = _numeroBiscotti;
		int percentuale = numeroBiscotti / 10;
		gradoSazieta += gradoSazieta * percentuale; //Aumenta del 10% il grado di sazieta precedente per ogni biscotto mangiato
		
	}
	
	//Se riceve carezze il suo grado di sazietà cala del doppio
	//rispetto agli altri, quindi il doppio del numero delle carezze
	//generate casualmente
	@Override
	public void riceviCarezze(int _numeroCarezze) {
		
		int raddoppia = _numeroCarezze * 2;
		this.gradoSazieta -= raddoppia;
		
	}
	
	//Controlla il livello di felicità (sazietà)
	@Override
	public boolean controllaFelicita() {
		
		boolean controllo = false;
		
		if(gradoSazieta < 30) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
	@Override
	//Verifica che il Tamagordo sia vivo
	public boolean controllaMorte() {
		
		boolean controllo = false;
		
		//Se il grado di sazietà raggiunge lo 0 anche in questo caso muore
		if(gradoSazieta == MINIMO) {
			
			controllo = true;
			
		}
		
		return controllo;
		
	}
	
	//Visualizza lo stato del Tamagordo
	public String toString() {
		
		return aCapo + nomeTama + nome + aCapo + specie + aCapo + sazieta 
			   + gradoSazieta + aCapo + soddisfazione + gradoSoddisfazione + aCapo;
		
	}
	
}
