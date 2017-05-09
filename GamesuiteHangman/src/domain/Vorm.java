package domain;

public abstract class Vorm {
	
	public Vorm(){
		
	}
	
	public abstract Omhullende getOmhullende();
	
	@Override
	public abstract String toString();
	
	
	//override??
	public abstract boolean equals();
}
