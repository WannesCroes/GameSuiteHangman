package ui;

import javax.swing.JOptionPane;

import domain.HangMan;
import domain.speler.Speler;
import domain.woord.WoordenLijst;

public class HangManUI {

	private final Speler speler;
	private WoordenLijst woordenlijst;

	public HangManUI(Speler speler, WoordenLijst woordenlijst) {
		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}

	public void play() {
		try {
			HangMan hangman = new HangMan(speler, woordenlijst);
			HangmanPaneel paneel = new HangmanPaneel(hangman);
			HangManHoofdScherm main = new HangManHoofdScherm(hangman, paneel);
			main.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
