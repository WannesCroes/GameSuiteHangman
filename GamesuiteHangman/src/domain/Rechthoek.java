package domain;

public class Rechthoek {
	private int breedte;
	private int hoogte;
	private Punt linkerBovenHoek;
	
	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
		this.setLinkerBovenHoek(linkerbovenhoek);
	}
	
	public Punt getLinkerBovenHoek() {
		return this.linkerBovenHoek;
	}
	
	public void setLinkerBovenHoek(Punt hoek) {
		if (hoek == null) {
			throw new DomainException("Geef een geldig punt");
		}
		this.linkerBovenHoek = hoek;
	}

	public int getBreedte() {
		return this.breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte <= 0) {
			throw new DomainException("breedte moet groter zijn dan nul");
		}
		this.breedte = breedte;
	}

	public int getHoogte() {
		return this.hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <= 0) {
			throw new DomainException("hoogte moet groter zijn dan nul");
		}
		this.hoogte = hoogte;
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: (" + this.linkerBovenHoek.getX() + ", " + this.linkerBovenHoek.getY() + ") - breedte: "
				+ this.getBreedte() + " - hoogte: " + this.getHoogte();
	}
	
	
	
	
	

}
