package domain.vorm;

import java.awt.Graphics;
import domain.exceptions.DomainException;

public class Rechthoek extends Vorm {

	private int breedte;
	private int hoogte;
	private Punt linkerBovenHoek;

	/**
	 * Constructor voor een rechthoek
	 * 
	 * @param linkerbovenhoek:
	 *            positie linkerbovenhoek van de rechthoek (Punt)
	 * @param breedte:
	 *            breedte van de rechthoek
	 * @param hoogte:
	 *            hoogte van de rechthoek
	 */
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

	@Override
	public Omhullende getOmhullende() {
		Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		if (isZichtbaar()) {
			graphics.drawRect(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(),
					this.getHoogte());
		}
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: (" + this.linkerBovenHoek.getX() + ", " + this.linkerBovenHoek.getY()
				+ ") - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte() + "\n" + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Rechthoek)) {
			return false;
		} else {
			Rechthoek other = (Rechthoek) obj;
			return (this.breedte == other.breedte && this.hoogte == other.hoogte
					&& this.linkerBovenHoek.equals(other.linkerBovenHoek));
		}
	}

}
