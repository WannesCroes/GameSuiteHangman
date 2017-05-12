package domain.vorm;

import java.awt.Graphics;
import domain.exceptions.DomainException;

public class LijnStuk extends Vorm {

	private Punt start;
	private Punt eind;

	/**
	 * Constructor voor een lijnstuk
	 * 
	 * @param start:
	 *            startpunt van het lijnstuk
	 * @param eind:
	 *            eindpunt van het lijnstuk
	 */
	public LijnStuk(Punt start, Punt eind) {
		this.setStartEnEindPunt(start, eind);
	}

	public Punt getStartPunt() {
		return this.start;
	}

	public Punt getEindPunt() {
		return this.eind;
	}

	public void setStartEnEindPunt(Punt start, Punt eind) {
		if (start == null || eind == null || start.equals(eind)) {
			throw new DomainException("punt is fout ingegeven");
		}
		this.start = start;
		this.eind = eind;
	}

	@Override
	public Omhullende getOmhullende() {
		int breedte = Math.abs(this.getStartPunt().getX() - this.getEindPunt().getX());
		int hoogte = Math.abs(this.getStartPunt().getY() - this.getEindPunt().getY());
		int x = Math.min(this.getStartPunt().getX(), this.getEindPunt().getX());
		int y = Math.min(this.getStartPunt().getY(), this.getEindPunt().getY());
		Punt linkerbovenpunt = new Punt(x, y);
		Omhullende omhullende = new Omhullende(linkerbovenpunt, breedte, hoogte);
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		if (isZichtbaar()) {
			graphics.drawLine(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(),
					this.getEindPunt().getY());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !(o instanceof LijnStuk)) {
			return false;
		} else {
			LijnStuk s = (LijnStuk) o;
			return (this.start.equals(s.start) && this.eind.equals(s.eind) ||
					this.start.equals(s.eind) && this.eind.equals(s.start));
		}
	}

	@Override
	public String toString() {
		String output = "Lijn: startpunt: " + start.toString() + " - eindpunt: " + eind.toString() + "\n"
				+ super.toString();
		return output;
	}

}
