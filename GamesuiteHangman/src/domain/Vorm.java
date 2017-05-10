package domain;

public abstract class Vorm {
	
	public Vorm(){
		
	}
	
	public abstract Omhullende getOmhullende();
	
	@Override
	public abstract String toString();
	
	
	@Override
	public abstract boolean equals(Object o);
}
