import java.util.*;

public class Strategia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mazzo Mazzone = new Mazzo();
		//Ordine Casuale
		OrdinamentoCarte MazzoCasuale = new OrdinamentoCasuale();
		MazzoCasuale.ordinaMazzo(Mazzone.GetSeme(),Mazzone.GetValore(),Mazzone.GetMazzo());
		System.out.print("Ordinamento CASUALE: \n");
		Mazzone.StampaMazzo();
		//Ordine Crescente
		OrdinamentoCarte MazzoCrescente = new OrdinamentoCrescente();
		MazzoCrescente.ordinaMazzo(Mazzone.GetSeme(),Mazzone.GetValore(),Mazzone.GetMazzo());
		System.out.print("Ordinamento CRESCENTE: \n");
		Mazzone.StampaMazzo();
	}
	
	
}

class Carta{
	private String[] semi = {"Bastone","Denari","Coppe","Spade"};
	private String[] valori = {"Asso","2","3","4","5","6","7","Fante","Cavallo","Re"};
	
	public Carta() {
	}
	public String[] GetSeme() {
		return semi;
	}
	public String[] GetValore() {
		return valori;
	}
}
class Mazzo extends Carta{
	Carta carta = new Carta();
	private List<String> mazzo = new ArrayList<>();
	
	public Mazzo() {
		for(String seme:carta.GetSeme()) {
			for (String valore:carta.GetValore()) {
				String carta = valore +" " + seme;
				mazzo.add(carta);//add vuole solo una stringa
			}
		}
	}
	
	public List<String> GetMazzo(){
		return mazzo;
	}
	public void StampaMazzo() {
		for (String carta : mazzo) {
			System.out.println(carta+ "\n");
		}
	}
}

interface OrdinamentoCarte {
 void ordinaMazzo(String[] semi,String[] valori,List<String> mazzo);
}

//strategy 1 
class OrdinamentoCasuale implements OrdinamentoCarte {
 @Override
 public void ordinaMazzo(String[] semi,String[] valori,List<String> mazzo) {
     Collections.shuffle(mazzo);
 }
}

//strategy 2
class OrdinamentoCrescente implements OrdinamentoCarte {
 @Override
 public void ordinaMazzo(String[] semi,String[] valori,List<String> mazzo) {
	 mazzo.clear();//pulisco il mazzo prima di riempirlo
	 for(String seme:semi) {
			for (String valore:valori) {
				mazzo.add(valore +" " + seme);
			}
	 	}
 	}
}
