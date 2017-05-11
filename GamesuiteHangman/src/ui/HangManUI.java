package ui;

import javax.swing.JOptionPane;

import domain.HintWoord;
import domain.Speler;
import domain.WoordenLijst;

public class HangManUI {
	
	Speler speler;
	WoordenLijst woordenlijst;
	
	public HangManUI(Speler speler, WoordenLijst woordenlijst){
		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}
	
	public void play(){
		HintWoord hintwoord = new HintWoord("test");
		String letter = JOptionPane.showInputDialog("Rarara, welk woord zoeken we \n" + hintwoord.toString() + "\n\n Geef een letter:");
		Boolean geraden = hintwoord.raad(letter.charAt(0));
		String l;
		while(hintwoord.isGeraden() == false){
		//geraden = hintwoord.raad(l.charAt(0));	

		if(geraden == true){ 
			l = JOptionPane.showInputDialog("Super, doe zo voort! \n Rarara, welk woord zoeken we \n" + hintwoord.toString() + "\n\n Geef een letter:");
		}else{
			l = JOptionPane.showInputDialog("Helaas, volgende keer beter! \n Rarara, welk woord zoeken we \n" + hintwoord.toString() + "\n\n Geef een letter:");
		}
		geraden = hintwoord.raad(l.charAt(0));	

		}
	}
}
