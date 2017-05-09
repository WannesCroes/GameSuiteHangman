package domain;

import java.util.ArrayList;

public class Driehoek extends Vorm{
	private Punt punt1;
	private Punt punt2;
	private Punt punt3;
	
	public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
		
	}
	
	public void setHoekpunten(Punt punt1, Punt punt2, Punt punt3){
		if(punt1 == null || punt2 == null || punt3 == null){
			throw new IllegalArgumentException("Hoekpunten mogen niet nul zijn");
		}
	
		this.punt1 = punt1;
		this.punt2 = punt2;
		this.punt3 = punt2;
	}
	public Punt getHoekPunt1(){
		return punt1;
	}
	
	public Punt getHoekPunt2(){
		return punt2;
	}
	public Punt getHoekPunt3(){
		return punt3;
	}
	
	@Override
	public boolean equals(Object object){
		if (object == this) {
			return true;
		}
		if(object == null){
			return false;
		}
		if(object instanceof Driehoek){
			Driehoek other = (Driehoek) object;
			
			ArrayList<Punt> puntenThis = new ArrayList<>();
			puntenThis.add(this.punt1);
			puntenThis.add(this.punt2);
			puntenThis.add(this.punt3);
			
			ArrayList<Punt> puntenOther = new ArrayList<>();
			puntenOther.add(other.punt1);
			puntenOther.add(other.punt2);
			puntenOther.add(other.punt3);
			
			for(Punt punt: puntenThis)
	        {
	            if(!puntenOther.contains(punt)) {
	                return false;
	            } else {
	            	puntenOther.remove(punt);
	            }
	        }
			return true;
		}
		return false;
	}
}
