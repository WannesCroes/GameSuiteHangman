package ui;

import javax.swing.JOptionPane;
import domain.exceptions.*;
import domain.speler.Speler;
import domain.woord.WoordenLijst;

public class Launcher {

	public static void main(String[] args) {
		try {
			Speler speler = createSpeler();

			String[] games = { "Hangman", "Pictionary" };
			String game = CustomJOption.showJOptionDropdownDialog("Dag " + speler.getNaam(), "welk spel wilt u spelen?",
					games, games[0]);

			if (game.equals("Pictionary")) {
				PictionaryUI ui = new PictionaryUI(speler);
				ui.showMenu();
			} else {
				HangManUI ui = new HangManUI(speler, new WoordenLijst(true));
				ui.play();
			}
		} catch (CancelledException e) {
			return;
		}
	}

	private static Speler createSpeler() throws CancelledException {
		Speler speler;
		try {
			String naam = CustomJOption.showJOptionInputDialog("Welkom! \nHoe heet je?", "Welkom");
			speler = new Speler(naam);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			speler = createSpeler();
		}
		return speler;
	}

}
