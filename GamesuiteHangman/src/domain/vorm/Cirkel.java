package domain.vorm;

import java.awt.Graphics;
import domain.exceptions.DomainException;

public class Cirkel extends Vorm {
	private int radius;
	private Punt middelpunt;

	/**
	 * Constructor voor een cirkel
	 * 
	 * @param middelpunt:
	 *            middelpunt van de cirkel
	 * @param radius:
	 *            straal van de cirkel
	 */
	public Cirkel(Punt middelpunt, int radius) {
		setRadius(radius);
		setMiddelpunt(middelpunt);
	}

	public int getRadius() {
		return this.radius;
	}

	private void setRadius(int radius) {
		if (radius <= 0) {
			throw new DomainException("Straal mag niet gelijk zijn aan 0");
		}

		this.radius = radius;
	}

	public Punt getMiddelpunt() {
		return this.middelpunt;
	}

	public void setMiddelpunt(Punt Middelpunt) {
		if (Middelpunt == null) {
			throw new DomainException("Middelpunt mag niet gelijk zijn aan 0");
		}

		this.middelpunt = Middelpunt;
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
		if (isZichtbaar()) {
			graphics.drawOval(this.getOmhullende().getMinimaleX(), this.getOmhullende().getMinimaleY(),
					this.getOmhullende().getBreedte(), this.getOmhullende().getHoogte());
		}
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (object == null || !(object instanceof Cirkel)) {
			return false;
		} else {
			Cirkel cirkel = (Cirkel) object;
			if (this.getMiddelpunt().equals(cirkel.getMiddelpunt()) && this.getRadius() == cirkel.getRadius()) {
				return true;
			}
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cirkel: Middelpunt: " + this.getMiddelpunt() + " - straal: " + this.getRadius() + "\n" + super.toString();
	}
}
