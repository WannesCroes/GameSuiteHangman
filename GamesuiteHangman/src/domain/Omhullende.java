package domain;

public class Omhullende {
	private Punt positieLinksBoven;
	private int hoogte;
	private int breedte;
	
	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte){
		setPositieLinksBoven(positieLinksBoven);
		setHoogte(hoogte);
		setBreedte(breedte);
	}
	
	public Punt getLinkerBoven() {
		return positieLinksBoven;
	}

	public int getHoogte() {
		return hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setPositieLinksBoven(Punt positieLinksBoven){
		if(positieLinksBoven == null){
			throw new DomainException("geef een geldige punt in voor de positie links boven");
		}
		this.positieLinksBoven = positieLinksBoven;
	}
	
	public void setHoogte(int hoogte){
		if(hoogte < 0){
			throw new DomainException("geef een geldige hoogte in");
		}
		this.hoogte = hoogte;
	}
	
	public void setBreedte(int breedte){
		if(breedte < 0){
			throw new DomainException("geef een geldige breedte in");
		}
		this.breedte = breedte;
	}
	
	
	public int getMinimaleX(){
		return this.getLinkerBoven().getX();
	}
	public int getMinimaleY(){
		return this.getLinkerBoven().getY();
	}
	public int getMaximaleX(){
		return this.getLinkerBoven().getX() + this.getBreedte();
	}
	public int getMaximaleY(){
		return this.getLinkerBoven().getY() + this.getHoogte();
	}
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		
		if(object instanceof Omhullende){
			Omhullende omhullende = (Omhullende) object;
			if(this.getLinkerBoven().equals(omhullende.getLinkerBoven()) && this.breedte == omhullende.getBreedte() && this.hoogte == omhullende.getHoogte()){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String toString(){
		return "Omhullende: " + this.getLinkerBoven() + " - "  + this.getBreedte() + " - " + this.getHoogte();
	}
		
}
