package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rechthoek extends Vorm {
	private int breedte;
	private int hoogte;
	private Punt linkerBovenHoek;
	
	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
		this.setLinkerBovenhoek(linkerbovenhoek);
	}
	
	public Punt getLinkerBovenhoek() {
		return this.linkerBovenHoek;
	}
	
	public void setLinkerBovenhoek(Punt hoek) {
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
	
	public Omhullende getOmhullende(){
		Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
		return omhullende;
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: (" + this.linkerBovenHoek.getX() + ", " + this.linkerBovenHoek.getY() + ") - breedte: "
				+ this.getBreedte() + " - hoogte: " + this.getHoogte() + "\n" + "Omhullende: " + this.getOmhullende().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Rechthoek)) {
			return false;
		}
		Rechthoek other = (Rechthoek) obj;
		if (breedte != other.breedte) {
			return false;
		}
		if (hoogte != other.hoogte) {
			return false;
		}
		if (!linkerBovenHoek.equals(other.linkerBovenHoek)) {
			return false;
		}
		return true;
	}

	@Override
	public void teken(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		
		graphics.drawRect(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(),
				this.getBreedte(), this.getHoogte());
		
	}

	
	
	

}
