package ui;

import javax.swing.JOptionPane;

import domain.HintWoord;
import domain.Speler;
import domain.WoordenLijst;
import domain.exceptions.DatabaseException;

public class HangManUI {

	Speler speler;
	WoordenLijst woordenlijst;

	public HangManUI(Speler speler, WoordenLijst woordenlijst) {
		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}

	public void play() throws DatabaseException {
		TekeningHangMan hangman = new TekeningHangMan();
		GameHoofdScherm main = new GameHoofdScherm("hangman", hangman);

		HintWoord hintwoord = new HintWoord(this.woordenlijst.getRandomWoord());
		
		String l;
		boolean start = true;
		boolean geraden = false;
		while (hintwoord.isGeraden() == false) {
			if (geraden || start) {
				l = JOptionPane.showInputDialog("Super, doe zo voort! \n Rarara, welk woord zoeken we \n"
						+ hintwoord.toString() + "\n\n Geef een letter:");
			} else {
				hangman.zetVolgendeZichtbaar();
				main.teken();
				
				l = JOptionPane.showInputDialog("Helaas, volgende keer beter! \n Rarara, welk woord zoeken we \n"
						+ hintwoord.toString() + "\n\n Geef een letter:");
			}
			
			start = false;
			geraden = hintwoord.raad(l.charAt(0));

		}
	}
}
