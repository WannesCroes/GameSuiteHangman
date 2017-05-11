package domain.woord;

import java.util.ArrayList;
import java.util.Random;

import db.WoordenLezer;
import domain.exceptions.DomainException;

public class WoordenLijst {

	ArrayList<String> woordenlijst;

	/**
	 * Constructor voor een woordenlijst met hintwoorden
	 */
	public WoordenLijst(boolean useDB) {
		if (useDB) {
			this.woordenlijst = WoordenLezer.getInstance().getAlleWoorden();
		} else {
			this.woordenlijst = new ArrayList<String>();
		}
	}

	public int getAantalWoorden() {
		return woordenlijst.size();
	}

	public void voegToe(String woord) throws DomainException {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("het woord mag niet leeg of null zijn");
		}

		if (woordenlijst.contains(woord)) {
			throw new DomainException("het woord zit al in de woordenlijst");
		}

		woordenlijst.add(woord);
	}

	public String getRandomWoord() throws DomainException {
		if (this.getAantalWoorden() == 0) {
			return null;
		} else if (this.getAantalWoorden() == 1) {
			return woordenlijst.get(0);
		} else {
			Random rand = new Random();
			int index = rand.nextInt(getAantalWoorden());
			return woordenlijst.get(index);
		}
	}
	
	public void reset() {
		woordenlijst.clear();
	}
}
