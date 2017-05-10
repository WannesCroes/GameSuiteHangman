package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm {
	Punt start;
	Punt eind;
	
	public LijnStuk(Punt start, Punt eind){
		this.setStartEnEindPunt(start, eind);
	}
	public Punt getStartPunt() {
		return start;
	}
	public Punt getEindPunt(){
		return eind;
	}
	public void setStartEnEindPunt(Punt start, Punt eind){
		if(start == null || eind == null || start.equals(eind)) {
			throw new DomainException("punt is fout ingegeven");
		}
		this.start = start;
		this.eind = eind;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof LijnStuk)){
			return false;
		} else if(o == this) {
			return true;
		} else {
			LijnStuk s = (LijnStuk) o;
			if (this.start == s.start && this.eind == s.eind);
			return true;
		}		
	}
	@Override
	public String toString(){
		String output = "Lijn: startpunt: " + start.toString() + " - eindpunt: " + eind.toString() + "\n" + "Omhullende: " + this.getOmhullende().toString();
		return output;
	}
	@Override
	public Omhullende getOmhullende() {
		int breedte = Math.abs(this.getStartPunt().getX() - this.getEindPunt().getX());
		int hoogte = Math.abs(this.getStartPunt().getY() - this.getEindPunt().getY());
		int x = Math.min(this.getStartPunt().getX(), this.getEindPunt().getX());
		int y = Math.min(this.getStartPunt().getY(), this.getEindPunt().getY());
		Punt linkerbovenpunt = new Punt(x,y);
		Omhullende omhullende = new Omhullende(linkerbovenpunt, breedte, hoogte);
		return omhullende;
	}
	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}
	
}
