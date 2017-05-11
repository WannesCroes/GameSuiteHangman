package domain.vorm;

public class Punt {

	private int x;
	private int y;

	/**
	 * Constructor voor een punt
	 * 
	 * @param x:
	 *            x-coordinaat van het punt
	 * @param y:
	 *            y-coordinaat van het punt
	 */
	public Punt(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	private void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null || !(o instanceof Punt)) {
			return false;
		} else {
			Punt s = (Punt) o;
			return (this.x == s.x && this.y == s.y);
		}
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
