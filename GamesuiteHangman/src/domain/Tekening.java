package domain;

import java.util.ArrayList;

public class Tekening {
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	ArrayList<Vorm> vormen = new ArrayList<>();
	
	public Tekening(String naam){
		this.setNaam(naam);
	}
	public void voegToe(Vorm vorm){
		vormen.add(vorm);
	}
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	//public Vorm getVorm(int index){
	//	return index;
	//}
	public int getAantalVormen(){
		return vormen.size();
	}
	public void verwijder(Vorm vorm){
		vormen.remove(vorm);
	}
	public boolean bevat(Vorm vorm){
		for( Vorm index: vormen){
		}
		return false;
	}
	public ArrayList<Vorm> getVormen() {
		return vormen;
	}

	public void setVormen(ArrayList<Vorm> vormen) {
		this.vormen = vormen;
	}
}
