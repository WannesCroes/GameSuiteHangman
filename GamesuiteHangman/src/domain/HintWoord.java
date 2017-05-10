package domain;

import java.util.ArrayList;

public class HintWoord {
	private String woord;
	private boolean geraden;
	ArrayList<Character> GeradenLetters = new ArrayList<>();
	
	public HintWoord(String woord){
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("geef een woord in");
		}
		this.woord = woord.toLowerCase();
	}
	
	public boolean raad(Character letter){
		letter = Character.toLowerCase(letter);
		if(GeradenLetters.contains(letter)){
			return false;
		}
		GeradenLetters.add(letter);
		if(geraden == true){
			return false;
		}
		
		String l = Character.toString(letter).toLowerCase();
		
		for(int i = 0; i < woord.length(); i++){
			String lwoord = Character.toString(woord.charAt(i)).toLowerCase();
			if(l.equalsIgnoreCase(lwoord)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGeraden(){
		if(this.toString().contains("_")){
			geraden= false;
		}else{
			geraden = true;
		}
		return geraden;
	}
	
	public String toString(){
		String temp= "";
		for(int i = 0; i < this.woord.length(); i++){
			if(GeradenLetters.contains((Character) this.woord.charAt(i))){
				temp += Character.toLowerCase(this.woord.charAt(i)) + " ";
			}else{
				temp+= "_ ";
			}
		}
		String sub = temp.substring(0, temp.length()-1);
		return sub;
	}
	
	public String getWoord(){
		
		return woord;
	}
		
}
