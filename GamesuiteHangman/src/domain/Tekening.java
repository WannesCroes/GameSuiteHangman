package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

import domain.exceptions.DomainException;
import domain.vorm.Drawable;
import domain.vorm.Vorm;

public class Tekening implements Drawable {
	private String naam;
	public static final int MIN_X = 0;
	public static final int MIN_Y = 0;
	public static final int MAX_X = 399;
	public static final int MAX_Y = 399;
	LinkedList<Vorm> vormen = new LinkedList<>();

	/**
	 * Constructor
	 * 
	 * @param naam:
	 *            naam van de tekening
	 */
	public Tekening(String naam) {
		this.setNaam(naam);
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Naam mag niet leeg zijn");
		}

		this.naam = naam;
	}

	public Vorm getVorm(int index) {
		return vormen.get(index);
	}

	public int getAantalVormen() {
		return vormen.size();
	}

	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		return vormen.contains(vorm);
	}

	public void voegToe(Vorm vorm) {
		if (vorm.getOmhullende().getMinimaleX() < MIN_X || vorm.getOmhullende().getMaximaleX() > MAX_X
				|| vorm.getOmhullende().getMinimaleY() < MIN_Y ||  vorm.getOmhullende().getMaximaleY() > MAX_Y ) {
			
			throw new DomainException("Vorm valt buiten de tekening.");
		}

		vormen.add(vorm);
	}

	@Override
	public void teken(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(2));

		for (Vorm vorm : vormen) {
			vorm.teken(graphics);
		}
	}

	@Override
	public String toString() {
		String output = "Tekening met naam " + this.getNaam() + " bestaat uit " + getAantalVormen() + " vormen :\n";
		for (Vorm v : vormen) {
			output += v.toString() + "\n";
		}
		return output;

	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !(o instanceof Tekening)) {
			return false;
		} else {
			Tekening tekening = (Tekening) o;

			if (tekening.vormen.size() != this.vormen.size()) {
				return false;
			}

			ArrayList<Vorm> duplicate = new ArrayList<>();
			duplicate.addAll(tekening.vormen);
			for (Vorm vorm : vormen) {
				if (!duplicate.contains(vorm)) {
					return false;
				} else {
					duplicate.remove(vorm);
				}
			}
			
			return true;
		}
	}

}
