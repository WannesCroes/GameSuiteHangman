package domain;

import java.util.ArrayList;
import java.util.Random;

import db.WoordenLezer;

public class WoordenLijst {

	ArrayList<String> woordenlijst;

	public WoordenLijst() {
		this.woordenlijst = WoordenLezer.getInstance().getAlleWoorden();
	}

	public int getAantalWoorden() {
		return woordenlijst.size();
	}

	public void voegToe(String woord) throws DomainException {
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("geen geldige naam");
		}
		if(woordenlijst.contains(woord)){
			throw new DomainException("geen geldige naam");
		}
		woordenlijst.add(woord);
	}

	public String getRandomWoord() throws DomainException {
		if (this.getAantalWoorden() == 0) return null;
		else if(this.getAantalWoorden() == 1) return woordenlijst.get(1);
		else {
			Random rand = new Random();
			int index = rand.nextInt(getAantalWoorden());
			return woordenlijst.get(index);
		}
	}
}
