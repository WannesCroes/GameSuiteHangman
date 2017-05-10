package domain;

public abstract class Vorm implements Drawable{
	private boolean zichtbaar = true;
	
	public Vorm(){
	}
	
	public abstract Omhullende getOmhullende();
	
	public abstract boolean isZichtbaar();
	
	public abstract void setZichtbaar(boolean zichtbaar);
	
	@Override
	public abstract String toString();
	
	@Override
	public abstract boolean equals(Object o);
}
