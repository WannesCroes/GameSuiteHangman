package domain;

public class Speler {
	
	private String naam;
	private int score = 0;
	
	public Speler(String naam){
		setNaam(naam);
	}

	private void setNaam(String naam) throws DomainException {
		if(naam == null || naam.isEmpty()){
			throw new DomainException("Geef een geldige naam");
		}
		this.naam = naam;
	}

	public void addToScore(int score) throws DomainException{
		if(this.score + score < 0){
			throw new DomainException("score moet groter zijn dan 0");
		}
		this.score += score;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public int getScore(){
		return score;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof Speler)){
			return false;
		} else if(o == this) {
			return true;
		} else {
			Speler s = (Speler) o;
			return (this.naam == s.naam && this.score == s.score);
		}
	}
	
	@Override
	public String toString(){
		return this.naam + "heeft als score: " + this.score;
	}
}
