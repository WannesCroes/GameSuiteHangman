package domain;

import domain.vorm.Cirkel;
import domain.vorm.LijnStuk;
import domain.vorm.Punt;
import domain.vorm.Rechthoek;
import domain.vorm.Vorm;
import ui.UiException;

public class TekeningHangMan extends Tekening {
	private int aantalZichtbaar = 4;

	public TekeningHangMan() {
		super("HangMan");

		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);

		hoofd.setZichtbaar(false);
		oogLinks.setZichtbaar(false);
		oogRechts.setZichtbaar(false);
		neus.setZichtbaar(false);
		mond.setZichtbaar(false);
		lijf.setZichtbaar(false);
		beenLinks.setZichtbaar(false);
		beenRechts.setZichtbaar(false);
		voetLinks.setZichtbaar(false);
		voetRechts.setZichtbaar(false);
		armLinks.setZichtbaar(false);
		armRechts.setZichtbaar(false);
		handLinks.setZichtbaar(false);
		handRechts.setZichtbaar(false);

		super.voegToe(galgBodem);
		super.voegToe(galgStaaf);
		super.voegToe(hangbar);
		super.voegToe(koord);
		super.voegToe(hoofd);
		super.voegToe(oogLinks);
		super.voegToe(oogRechts);
		super.voegToe(neus);
		super.voegToe(mond);
		super.voegToe(lijf);
		super.voegToe(beenLinks);
		super.voegToe(beenRechts);
		super.voegToe(voetLinks);
		super.voegToe(voetRechts);
		super.voegToe(armLinks);
		super.voegToe(armRechts);
		super.voegToe(handLinks);
		super.voegToe(handRechts);
	}

	public int getAantalOnzichtbaar() {
		return getAantalVormen() - aantalZichtbaar;
	}

	public void zetVolgendeZichtbaar() {
		if (alleVormenZichtbaar()) {
			throw new UiException("Alle vormen zijn al zichtbaar");
		}

		getVorm(aantalZichtbaar).setZichtbaar(true);
		aantalZichtbaar++;
	}

	public boolean alleVormenZichtbaar() {
		return aantalZichtbaar == getAantalVormen();
	}

	public void reset() {
		for (int i = 4; i < getAantalVormen(); i++) {
			getVorm(i).setZichtbaar(false);
		}
		aantalZichtbaar = 4;
	}

	@Override
	public void voegToe(Vorm vorm) {
		throw new UiException("Er mogen geen vormen toegevoegd worden aan de hangman tekening");
	}

	@Override
	public void verwijder(Vorm vorm) {
		throw new UiException("Er mogen geen vormen verwijderd worden van de hangman tekening");
	}
}