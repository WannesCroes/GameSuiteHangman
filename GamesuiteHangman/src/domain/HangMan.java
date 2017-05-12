package domain;

import domain.exceptions.DomainException;
import domain.speler.Speler;
import domain.woord.HintWoord;
import domain.woord.WoordenLijst;

public class HangMan {

	private Speler speler;
	private WoordenLijst woorden;
	private HintWoord hintwoord;
	private TekeningHangMan tekening;

	/**
	 * Constructor voor HangMan spel
	 * 
	 * @param speler
	 * @param woordenlijst
	 */
	public HangMan(Speler speler, WoordenLijst woordenlijst) {
		setSpeler(speler);
		setWoordenLijst(woordenlijst);
		this.hintwoord = new HintWoord(woordenlijst.getRandomWoord());
		this.tekening = new TekeningHangMan();
	}

	public Speler getSpeler() {
		return this.speler;
	}

	private void setSpeler(Speler speler) {
		if (speler == null) {
			throw new DomainException("Geef een geldige naam");
		}

		this.speler = speler;
	}
	
	private void setWoordenLijst(WoordenLijst woordenlijst) {
		if (woordenlijst == null || woordenlijst.getAantalWoorden() == 0) {
			throw new DomainException("woordenlijst mag niet null zijn");
		}
		
		this.woorden = woordenlijst;
	}

	public String getHint() {
		return this.hintwoord.toString();
	}

	public TekeningHangMan getTekening() {
		return this.tekening;
	}

	public void raad(char l) {
		boolean correct = this.hintwoord.raad(l);

		if (!correct) {
			this.tekening.zetVolgendeZichtbaar();
		}
	}

	/**
	 * Men verliest indien alle vormen van de hangman zichtbaar zijn
	 * 
	 * @return boolean
	 */
	public boolean isGameOver() {
		return this.tekening.alleVormenZichtbaar();
	}

	/**
	 * Men wint indien alle characters waaruit het hintwoord bestaat geraden
	 * zijn
	 * 
	 * @return boolean
	 */
	public boolean isGewonnen() {
		return this.hintwoord.isGeraden();
	}

	/**
	 * Reset methode voor wanneer het spel opnieuw wordt gespeeld
	 */
	public void reset() {
		this.hintwoord = new HintWoord(woorden.getRandomWoord());
		tekening.reset();
	}

}
