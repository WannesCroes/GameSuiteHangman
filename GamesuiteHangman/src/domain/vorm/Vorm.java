package domain.vorm;

public abstract class Vorm implements Drawable {
	private boolean zichtbaar;

	public Vorm() {
		this.setZichtbaar(true);
	}

	public abstract Omhullende getOmhullende();

	public boolean isZichtbaar() {
		return this.zichtbaar;
	}

	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;
	}
	
	public String toString(){
		return  "Omhullende: " + this.getOmhullende().toString();
	}

}
