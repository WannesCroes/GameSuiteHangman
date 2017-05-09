package domain;

public class Punt {

	private int x;
	private int y;
	
	public Punt(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	@Override 
	public boolean equals(Object o){
		if(o == null || !(o instanceof Punt)){
			return false;
		} else if(o == this) {
			return true;
		} else {
			Punt s = (Punt) o;
			return (this.x== s.x && this.y == s.y);
		}
	}
	
	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		String output = "(" + x + ", " + y + ")";
		return output;
		
	}
}
