package domain;

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
	public Boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(object instanceof Driehoek){
			Driehoek driehoek = (Driehoek) object;
			
			
		}
		
	}
}
