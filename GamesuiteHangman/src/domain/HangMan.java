package domain;

import ui.TekeningHangMan;

public class HangMan {
	private String speler;
	private WoordenLijst woorden;
	private HintWoord hintwoord;
	private TekeningHangMan tekening;
	
	public HangMan(String speler, WoordenLijst woordenlijst) {
		this.speler = speler;
		this.woorden = woordenlijst;
		this.hintwoord = new HintWoord(woordenlijst.getRandomWoord());
		this.tekening = new TekeningHangMan();
	}
	
	public String getHint() {
		return this.hintwoord.toString();
	}
	
	public String getSpeler() {
		return this.speler;
	}
	
	public TekeningHangMan getTekening() {
		return this.tekening;
	}
	
	public void raad(char l) {
		boolean guess = this.hintwoord.raad(l);
		
		if (!guess) {
			this.tekening.zetVolgendeZichtbaar();
		}
	}
	
	public boolean isGameOver() {
		return this.tekening.alleVormenZichtbaar();
	}
	
	public boolean isGewonnen() {
		return this.hintwoord.isGeraden();
	}
	
	public void reset() {
		this.hintwoord = new HintWoord(woorden.getRandomWoord());
		tekening.reset();
	}

}
