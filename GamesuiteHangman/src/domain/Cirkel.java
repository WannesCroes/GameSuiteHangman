package domain;

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
		return "Cirkel: Middelpunt: " + this.getMiddelpunt() + " - straal: " + this.getRadius();		
	}
	
}
