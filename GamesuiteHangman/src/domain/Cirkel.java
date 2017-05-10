package domain;

import java.awt.Graphics;

public class Cirkel extends Vorm {
	private int radius;
	private Punt middelpunt;
	
	
	public Cirkel(Punt middelpunt, int radius){
		setRadius(radius);
		setMiddelpunt(middelpunt);
	}
	
	private void setRadius(int radius){
		if(radius <= 0 ){
			throw new DomainException("Straal mag niet gelijk zijn aan 0");
		}
		this.radius = radius;
	}
	public int getRadius(){
		return radius;
		
	}
	public void setMiddelpunt(Punt Middelpunt){
		if(Middelpunt == null ){
			throw new DomainException("Middelpunt mag niet gelijk zijn aan 0");
		}
		this.middelpunt = Middelpunt;
	}
	
	public Punt getMiddelpunt(){
		return middelpunt;
	}
	
	@Override
	public boolean equals(Object object){
		if(object ==null){
			return false;
		}
		if(object instanceof Cirkel){
			Cirkel cirkel = (Cirkel) object;
			if(this.getMiddelpunt().equals(cirkel.getMiddelpunt()) && this.getRadius() == cirkel.getRadius()){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String toString(){
		return "Cirkel: Middelpunt: " + this.getMiddelpunt() + " - straal: " + this.getRadius()+ "\n" + "Omhullende: " + this.getOmhullende().toString();		
	}

	@Override
	public Omhullende getOmhullende() {
		int breedte = this.radius * 2;
		int hoogte = this.radius * 2;
		Punt positieLinkerBoven = new Punt(this.middelpunt.getX() - this.radius, this.middelpunt.getY() - this.radius);
		Omhullende omhullende = new Omhullende(positieLinkerBoven, breedte, hoogte);
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}
	
}
