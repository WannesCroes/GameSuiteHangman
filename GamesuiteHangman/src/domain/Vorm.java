package domain;

public abstract class Vorm implements Drawable{
	
	public Vorm(){
		
	}
	
	public abstract Omhullende getOmhullende();
	
	@Override
	public abstract String toString();
	
	
	@Override
	public abstract boolean equals(Object o);
}
