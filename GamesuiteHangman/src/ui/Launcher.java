package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		
		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt punt = new Punt(x,y);
		
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		
	////////////////////
		int straal = Integer.parseInt(JOptionPane.showInputDialog("straal voor de cirkel:"));
		Cirkel cirkel = new Cirkel(punt, straal);
		
		JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	}

}
