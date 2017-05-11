package ui;

import javax.swing.JOptionPane;

import domain.Tekening;
import domain.exceptions.CancelledException;
import domain.exceptions.DomainException;
import domain.speler.Speler;
import domain.vorm.Cirkel;
import domain.vorm.Driehoek;
import domain.vorm.LijnStuk;
import domain.vorm.Punt;
import domain.vorm.Rechthoek;

public class PictionaryUI {
	private final Speler speler;
	private Tekening tekening;

	public PictionaryUI(Speler speler) {
		this.speler = speler;
	}

	public void showMenu() {
		try {
			while (true) {
				this.tekening = createTekening();

				String[] opties = { "Vorm maken", "Tekening tonen", "Stoppen" };

				while (true) {
					String keuze = CustomJOption.showJOptionDropdownDialog("Wat wilt u doen?", "Input", opties,
							"Vorm maken");

					switch (keuze) {
					case "Vorm maken":
						maakVorm();
						break;

					case "Tekening tonen":
						toonTekening();
						break;

					case "Stoppen":
					default:
						throw new CancelledException("");
					}
				}
			}
		} catch (CancelledException e) {
			return;
		}
	}

	public void maakVorm() {
		try {
			String[] shapes = { "Cirkel", "Rechthoek", "LijnStuk", "Driehoek" };
			String keuze = CustomJOption.showJOptionDropdownDialog("Wat wilt u tekenen", "input", shapes, shapes[0]);

			if (keuze.equals("Cirkel")) {
				Punt punt = createPunt("middelpunt");

				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString(),
						speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

				Cirkel cirkel = createCirkel(punt);
				tekening.voegToe(cirkel);

				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(),
						speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

			} else if (keuze.equals("Rechthoek")) {
				Punt punt = createPunt("linkerbovenhoekpunt");

				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString(),
						speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

				Rechthoek rechthoek = createRechthoek(punt);
				tekening.voegToe(rechthoek);

				JOptionPane.showMessageDialog(null,
						"U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString(), speler.getNaam(),
						JOptionPane.INFORMATION_MESSAGE);

			} else if (keuze.equals("LijnStuk")) {
				LijnStuk lijnstuk = createLijnstuk();
				tekening.voegToe(lijnstuk);

				JOptionPane.showMessageDialog(null, "U heeft een correct Lijnstuk aangemaakt: " + lijnstuk.toString());

			} else if (keuze.equals("Driehoek")) {
				Driehoek driehoek = createDriehoek();
				tekening.voegToe(driehoek);

				JOptionPane.showMessageDialog(null, "U heeft een correcte Driehoek aangemaakt: " + driehoek.toString());

			}
		} catch (CancelledException e) {
			return;
		}
	}

	public void toonTekening() {
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
	}

	private static Tekening createTekening() throws CancelledException {
		Tekening tekening;
		try {
			String naam = CustomJOption.showJOptionInputDialog("Geef de naam van je tekening:", "naam");
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
			int x = Integer.parseInt(CustomJOption.showJOptionInputDialog("x coordinaat van het punt:", soort));
			int y = Integer.parseInt(CustomJOption.showJOptionInputDialog("y coordinaat van het punt:", soort));
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
			int breedte = Integer.parseInt(CustomJOption.showJOptionInputDialog("Breedte van de rechthoek:", "input"));
			int hoogte = Integer.parseInt(CustomJOption.showJOptionInputDialog("Hoogte van de rechthoek:", "input"));
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
			int straal = Integer.parseInt(CustomJOption.showJOptionInputDialog("straal voor de cirkel:", "input"));
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
