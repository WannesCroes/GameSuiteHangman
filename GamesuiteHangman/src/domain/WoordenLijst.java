package domain;

import java.util.ArrayList;
import java.util.Random;

import domain.exceptions.DatabaseException;

public class WoordenLijst {

	ArrayList<String> woordenlijst;

	public WoordenLijst() {
		//this.woordenlijst = WoordenLezer.getInstance();
		woordenlijst = new ArrayList<>();
	}

	public int getAantalWoorden() {
		return woordenlijst.size();
	}

	public void voegToe(String woord) throws DatabaseException {
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("geen geldige naam");
		}
		if(woordenlijst.contains(woord)){
			throw new DomainException("geen geldige naam");
		}
		woordenlijst.add(woord);
	}

	public String getRandomWoord() throws DatabaseException {
		if (getAantalWoorden() == 0) return null;
		else if(getAantalWoorden() == 1) return woordenlijst.get(1);
		else {
			Random rand = new Random();
			int index = rand.nextInt(getAantalWoorden());
			return woordenlijst.get(index);
		}
	}
}
