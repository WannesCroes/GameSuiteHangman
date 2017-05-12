package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField letter;
	private JLabel woord;

	private TekenVenster tekenVenster;
	private HangMan spel;

	public HangmanPaneel(HangMan spel) {
		super();
		setSpel(spel);
		init();
	}

	private void init() {
		letter = new JTextField("", 5);
		woord = new JLabel("");

		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);

		letter.addKeyListener(new RaadLuisteraar());
	}

	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}
	
	private void setSpel(HangMan spel) {
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	
	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}

	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String input = letter.getText();
				char guess = '\u0000';
				if (input.length() > 0) {
					guess = input.charAt(0);
				}

				getSpel().raad(guess);

				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();

				if (getSpel().isGameOver()) {
					if(getSpel().getSpeler().getScore() > 0){
						getSpel().getSpeler().addToScore(-1);
					}
					quit("You Lost!!!", "Game Over");
					reset();
				}

				if (getSpel().isGewonnen()) {
					getSpel().getSpeler().addToScore(1);
					quit("You Won!!!", "Game Over");
					reset();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			/* Niet nodig */}

		@Override
		public void keyTyped(KeyEvent arg0) {
			/* Niet nodig */}
	}

	private void quit(String message, String title) {
		message += "\n\n" + getSpel().getSpeler().getNaam() +", uw score is: " + getSpel().getSpeler().getScore()
				+ "\n \nWilt u opnieuw spelen?";

		String[] keuzes = { "Ja", "Nee" };
		String keuze = (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null,
				keuzes, null);

		if (keuze == null || keuze.equals("Nee")) {
			System.exit(0);
		} else {
			getSpel().reset();
			this.reset();
		}
	}

}