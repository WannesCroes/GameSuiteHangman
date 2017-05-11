package domain.woord;

import java.util.ArrayList;

import domain.exceptions.DomainException;

public class HintWoord {

	private String woord;
	ArrayList<Character> GeradenLetters = new ArrayList<>();

	/**
	 * Constructor voor een hintwoord
	 * 
	 * @param woord
	 */
	public HintWoord(String woord) {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("geef een woord in");
		}

		this.woord = woord.toLowerCase();
	}

	public String getWoord() {
		return woord;
	}

	public boolean raad(Character letter) {
		letter = Character.toLowerCase(letter);

		if (GeradenLetters.contains(letter)) {
			return false;
		}

		GeradenLetters.add(letter);

		String l = Character.toString(letter).toLowerCase();

		for (int i = 0; i < woord.length(); i++) {
			String lwoord = Character.toString(woord.charAt(i)).toLowerCase();
			if (l.equalsIgnoreCase(lwoord)) {
				return true;
			}
		}

		return false;
	}

	public boolean isGeraden() {
		if (this.toString().contains("_")) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < this.woord.length(); i++) {
			Character character = (Character) this.woord.charAt(i);
			if (character == ' ') {
				temp += "  ";
			} else if (GeradenLetters.contains(character)) {
				temp += Character.toLowerCase(this.woord.charAt(i)) + " ";
			} else {
				temp += "_ ";
			}
		}
		String sub = temp.substring(0, temp.length() - 1);
		return sub;
	}

}
