package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.HangMan;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;
import domain.WoordenLijst;
import domain.exceptions.*;

public class Launcher {

	public static void main(String[] args) {
		try {
			Speler speler = createSpeler();

			JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore(),
					speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

			String[] games = {"Hangman", "Pictionary"};
			String game = showJOptionDropdownDialog("Dag " + speler.getNaam(), "welk spel wilt u spelen?", 
					games, games[0]);

			if (game.equals("Pictionary")) {
				PictionaryUI ui = new PictionaryUI(speler);
				ui.showMenu();
			} else {
				WoordenLijst woordenlijst = new WoordenLijst();
				HangmanPaneel paneel = new HangmanPaneel(new HangMan(speler.getNaam(), woordenlijst));
				paneel.setVisible(true);
			}
		} catch (CancelledException e) {
			return;
		} catch (DatabaseException e) {
			JOptionPane.showMessageDialog(null, "hangman.txt bestaat niet",
					"critical error", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static String showJOptionInputDialog(String message, String title) throws CancelledException {
		String value = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

		if (value == null) {
			throw new CancelledException("User pressed the cancel button");
		} else {
			return value;
		}
	}

	private static String showJOptionDropdownDialog(String message, String title, String[] list, String selectedItem)
			throws CancelledException {
		String value = (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null,
				list, selectedItem);

		if (value == null) {
			throw new CancelledException("User pressed the cancel button");
		} else {
			return value;
		}
	}

	private static Speler createSpeler() throws CancelledException {
		Speler speler;
		try {
			String naam = showJOptionInputDialog("Welkom! \nHoe heet je?", "Welkom");
			speler = new Speler(naam);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			speler = createSpeler();
		}
		return speler;
	}

	private static Tekening createTekening() throws CancelledException {
		Tekening tekening;
		try {
			String naam = showJOptionInputDialog("Geef de naam van je tekening:", "naam");
			tekening = new Tekening(naam);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			tekening = createTekening();
		}
		return tekening;
	}

	private static Punt createPunt(String soort) throws CancelledException {
		Punt punt;
		try {
			int x = Integer.parseInt(showJOptionInputDialog("x coordinaat van het punt:", soort));
			int y = Integer.parseInt(showJOptionInputDialog("y coordinaat van het punt:", soort));
			punt = new Punt(x, y);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			punt = createPunt(soort);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "het punt moet geldige coordinaten hebben");
			punt = createPunt(soort);
		}
		return punt;
	}

	private static Rechthoek createRechthoek(Punt punt) throws CancelledException {
		Rechthoek rechthoek;
		try {
			int breedte = Integer.parseInt(showJOptionInputDialog("Breedte van de rechthoek:", "input"));
			int hoogte = Integer.parseInt(showJOptionInputDialog("Hoogte van de rechthoek:", "input"));
			rechthoek = new Rechthoek(punt, breedte, hoogte);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			rechthoek = createRechthoek(punt);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "de breedte/lengte moet een getal zijn");
			rechthoek = createRechthoek(punt);
		}
		return rechthoek;
	}

	private static Cirkel createCirkel(Punt punt) throws CancelledException {
		Cirkel cirkel;
		try {
			int straal = Integer.parseInt(showJOptionInputDialog("straal voor de cirkel:", "input"));
			cirkel = new Cirkel(punt, straal);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			cirkel = createCirkel(punt);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "de straal moet een getal zijn");
			cirkel = createCirkel(punt);
		}
		return cirkel;
	}

	private static LijnStuk createLijnstuk() throws CancelledException {
		LijnStuk lijnStuk;
		try {
			Punt startPunt = createPunt("startpunt (lijnstuk)");
			Punt eindPunt = createPunt("eindpunt (lijnstuk)");
			lijnStuk = new LijnStuk(startPunt, eindPunt);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, "het begin en eindpunt mogen niet dezelfde zijn");
			lijnStuk = createLijnstuk();
		}
		return lijnStuk;
	}

	private static Driehoek createDriehoek() throws CancelledException {
		Driehoek driehoek;
		try {
			Punt punt1 = createPunt("punt 1");
			Punt punt2 = createPunt("punt 2");
			Punt punt3 = createPunt("punt 3");
			driehoek = new Driehoek(punt1, punt2, punt3);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			driehoek = createDriehoek();
		}
		return driehoek;
	}

}
