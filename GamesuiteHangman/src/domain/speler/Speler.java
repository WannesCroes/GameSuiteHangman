package domain.speler;

import domain.exceptions.DomainException;

public class Speler {

	private String naam;
	private int score = 0;

	/**
	 * Constructor voor speler
	 * 
	 * @param naam:
	 *            naam van de speler
	 */
	public Speler(String naam) {
		setNaam(naam);
	}

	public String getNaam() {
		return this.naam;
	}

	private void setNaam(String naam) throws DomainException {
		if (naam == null || naam.isEmpty()) {
			throw new DomainException("Geef een geldige naam");
		}
		this.naam = naam;
	}

	public int getScore() {
		return this.score;
	}

	public void addToScore(int score) throws DomainException {
		if (this.score + score < 0) {
			throw new DomainException("score moet groter zijn dan 0");
		}
		this.score += score;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !(o instanceof Speler)) {
			return false;
		} else {
			Speler s = (Speler) o;
			return (this.naam.equals(s.naam) && this.score == s.score);
		}
	}

	@Override
	public String toString() {
		return this.naam + ", heeft als score: " + this.score;
	}
}
