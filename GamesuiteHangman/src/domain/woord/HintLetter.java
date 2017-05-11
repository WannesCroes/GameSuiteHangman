package domain.woord;

public class HintLetter {
	
	private char letter;
	private boolean geraden;

	/**
	 * Constructor voor een hintletter
	 * 
	 * @param letter
	 */
	public HintLetter(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return this.letter;
	}
	
	public boolean raad(char letter) {
		String l = Character.toString(this.letter);
		String l2 = Character.toString(letter);
		if (geraden == true) {
			return false;
		}
		if (l.equalsIgnoreCase(l2)) {
			geraden = true;
			return true;
		}
		return false;
	}

	public boolean isGeraden() {
		return geraden;
	}

	public char toChar() {
		if (geraden == true) {
			return this.letter;
		} else if (this.letter == ' ') {
			return this.letter;
		} else {
			return '_';
		}
	}
	
}
