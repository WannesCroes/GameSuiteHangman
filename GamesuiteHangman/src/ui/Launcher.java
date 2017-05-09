package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object[] shapes = {"Cirkel", "Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt punt = new Punt(x,y);
		
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		if (keuze.equals("Cirkel")) {
			int straal = Integer.parseInt(JOptionPane.showInputDialog("straal voor de cirkel:"));
			Cirkel cirkel = new Cirkel(punt, straal);
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		} else if (keuze.equals("Rechthoek")) {
			int breedte = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de rechthoek:"));
			int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Hoogte van de rechthoek:"));
			Rechthoek rechthoek = new Rechthoek(punt, breedte, hoogte);
			
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		}
		else if(keuze.equals("LijnStuk")){
			int xStart = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het Startpunt:"));
			int yStart = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het Startpunt:"));
			int xEind = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het Eindpunt:"));
			int yEind = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het Eindpunt:"));
			Punt startPunt = new Punt(xStart, yStart);
			Punt eindPunt = new Punt(xEind, yEind);
			LijnStuk lijnStuk = new LijnStuk(startPunt, eindPunt);
			
			JOptionPane.showMessageDialog(null, "U heeft een correct Lijnstuk aangemaakt: " + lijnStuk.toString());
		}
	}

}
