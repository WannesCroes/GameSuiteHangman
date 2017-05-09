package domain;

public class Punt {

	private int x;
	private int y;
	
	public Punt(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public boolean equals(int x,int y){
		if( x == y){
			return true;
		}
		return false;
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
	public String toString(){
		String output = "(" + x + ", " + y + ")";
		return output;
		
	}
}
