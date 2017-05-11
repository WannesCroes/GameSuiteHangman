package domain.vorm;

import domain.exceptions.DomainException;

public class Omhullende {
	private Punt positieLinksBoven;
	private int hoogte;
	private int breedte;

	/**
	 * Constructor voor een omhullende van een vorm
	 * 
	 * @param positieLinksBoven:
	 *            Positie linkerbovenhoek van de omhullende
	 * @param breedte:
	 *            De breedte van de omhullende
	 * @param hoogte:
	 *            De hoogte van de omhullende
	 */
	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
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

	public void setHoogte(int hoogte) {
		if (hoogte < 0) {
			throw new DomainException("geef een geldige hoogte in");
		}
		this.hoogte = hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		if (breedte < 0) {
			throw new DomainException("geef een geldige breedte in");
		}
		this.breedte = breedte;
	}

	public void setPositieLinksBoven(Punt positieLinksBoven) {
		if (positieLinksBoven == null) {
			throw new DomainException("geef een geldige punt in voor de positie links boven");
		}
		this.positieLinksBoven = positieLinksBoven;
	}

	public int getMinimaleX() {
		return this.getLinkerBoven().getX();
	}

	public int getMinimaleY() {
		return this.getLinkerBoven().getY();
	}

	public int getMaximaleX() {
		return this.getLinkerBoven().getX() + this.getBreedte();
	}

	public int getMaximaleY() {
		return this.getLinkerBoven().getY() + this.getHoogte();
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (object == null || !(object instanceof Omhullende)) {
			return false;
		} else {
			Omhullende omhullende = (Omhullende) object;
			if (this.getLinkerBoven().equals(omhullende.getLinkerBoven()) && this.breedte == omhullende.getBreedte()
					&& this.hoogte == omhullende.getHoogte()) {
				return true;
			}
			return false;
		}
	}

	@Override
	public String toString() {
		return "Omhullende: " + this.getLinkerBoven() + " - " + this.getBreedte() + " - " + this.getHoogte();
	}

}
