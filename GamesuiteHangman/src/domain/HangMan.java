package domain;

import ui.TekeningHangMan;

public class HangMan {
	private Speler speler;
	private WoordenLijst woorden;
	private HintWoord hintwoord;
	private TekeningHangMan tekening;
	
	public HangMan(Speler speler, WoordenLijst woordenlijst) {
		setSpeler(speler);
		this.woorden = woordenlijst;
		this.hintwoord = new HintWoord(woordenlijst.getRandomWoord());
		this.tekening = new TekeningHangMan();
	}
	
	private void setSpeler(Speler speler){
		if(speler == null){
			throw new DomainException("Geef een geldige naam");
		}
		this.speler = speler;
	}
	
	public String getHint() {
		return this.hintwoord.toString();
	}
	
	public Speler getSpeler() {
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
