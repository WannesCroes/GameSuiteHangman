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
		if(naam == null || naam.trim().isEmpty()) throw new DomainException("Naam mag niet leeg zijn");
		this.naam = naam;
	}
	
	public Vorm getVorm(int index){
		return vormen.get(index);
	}
	public int getAantalVormen(){
		return vormen.size();
	}
	public void verwijder(Vorm vorm){
		vormen.remove(vorm);
	}
	public boolean bevat(Vorm vorm){
		for( Vorm v: vormen){
			if(vorm.equals(v)) return true;
		}
		return false;
	}
	
	public ArrayList<Vorm> getVormen() {
		return vormen;
	}

	public void setVormen(ArrayList<Vorm> vormen) {
		this.vormen = vormen;
	}
	@Override
	public String toString(){
		String output = "Tekening met naam boom bestaat uit " + getAantalVormen() + "vormen :\n" ;
		for(Vorm v: vormen){
			output += v.toString() + "\n";
		}
		return output;
		
	}
	@Override
	public boolean equals(Object o){
		if( o == this) return true;
		if( o == null || !(o instanceof Tekening)) return false;
		Tekening tekening = (Tekening) o;
		if(tekening.getNaam() != this.getNaam()) return false;
		
		if(tekening.getVormen().size() != this.vormen.size()) return false;
		ArrayList<Vorm> duplicate = new ArrayList<>();
		duplicate.addAll(tekening.getVormen());
		for(Vorm vorm: vormen)
        {
            if(!duplicate.contains(vorm)) {
                return false;
            } else {
            	duplicate.remove(vorm);
            }
        }
		return true;
	}
}
