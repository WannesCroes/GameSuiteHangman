package domain;

import java.util.Random;

import db.WoordenLezer;
import domain.exceptions.DatabaseException;

public class WoordenLijst {
	
	WoordenLezer woordenlijst;
	public WoordenLijst(){
		this.woordenlijst = WoordenLezer.getInstance();
	}
	
	public int getAantalWoorden(){
		return woordenlijst.getAlleWoorden().size();
	}
	public void voegToe(String woord) throws DatabaseException{
		woordenlijst.addWoord(woord);;
	}
	public String getRandomWoord() throws DatabaseException{
		if (getAantalWoorden() == 0) return null;
		Random rand = new Random();
		int index = rand.nextInt(getAantalWoorden());
		return woordenlijst.getWoord(index);
	}
}
