package domain;

public class LijnStuk extends Vorm {
	Punt start;
	Punt eind;
	
	public LijnStuk(Punt start, Punt eind){
		this.setStartEnEindPunt(start, eind);
	}
	public Punt getStartPunt() {
		return start;
	}
	public Punt getEindPunt(){
		return eind;
	}
	public void setStartEnEindPunt(Punt start, Punt eind){
		if(start == null || eind == null || start.equals(eind)) {
			throw new DomainException("punt is fout ingegeven");
		}
		this.start = start;
		this.eind = eind;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof LijnStuk)){
			return false;
		} else if(o == this) {
			return true;
		} else {
			LijnStuk s = (LijnStuk) o;
			return (this.start == s.eind && this.start == s.eind);
		}		
	}
	@Override
	public String toString(){
		String output = "Lijn: startpunt: " + start.toString() + " - eindpunt: " + eind.toString();
		return output;
	}
	
}
