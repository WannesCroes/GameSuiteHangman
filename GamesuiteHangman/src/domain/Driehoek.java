package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Driehoek extends Vorm{
	private Punt punt1;
	private Punt punt2;
	private Punt punt3;
	
	public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
		setHoekpunten(punt1,punt2,punt3);
	}
	
	public void setHoekpunten(Punt punt1, Punt punt2, Punt punt3){
		if(punt1 == null || punt2 == null || punt3 == null){
			throw new DomainException("Hoekpunten mogen niet nul zijn");
		}
		if(punt1.equals(punt2) || punt2.equals(punt3) || punt1.equals(punt3)){
			throw new DomainException("2 punten mogen niet gelijk zijn aan elkaar");
		}
		
		if( (punt2.getX() - punt1.getX()* punt3.getY() - punt1.getY()) == (punt3.getX() - punt1.getX() * punt2.getY() - punt1.getY())){
			throw new DomainException("de 3 hoekpunten liggen op 1 lijn");
		}
		this.punt1 = punt1;
		this.punt2 = punt2;
		this.punt3 = punt3;
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
	@Override
	public String toString(){
		return "Driehoek: hoekpunt1: " + this.getHoekPunt1().toString() + " - hoekpunt2: " + this.getHoekPunt2().toString() + " - hoekpunt3: " + this.getHoekPunt3().toString() + "\n" + "Omhullende: " + this.getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		int x = Math.min(this.getHoekPunt1().getX(), Math.min(this.getHoekPunt2().getX(), this.getHoekPunt3().getX()));
		int y = Math.min(this.getHoekPunt1().getY(), Math.min(this.getHoekPunt2().getY(), this.getHoekPunt3().getY()));
		Punt linkerBoven = new Punt(x, y);
		int max = Math.max(this.getHoekPunt1().getX(), Math.max(this.getHoekPunt2().getX(), this.getHoekPunt3().getX()));
		int maxy = Math.max(this.getHoekPunt1().getY(), Math.max(this.getHoekPunt2().getY(), this.getHoekPunt3().getY()));

		int breedte = max -x;
		int hoogte = maxy- y;
		
		Omhullende omhullende = new Omhullende(linkerBoven, breedte, hoogte);
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		
		int[] xPoints = { this.getHoekPunt1().getX(), this.getHoekPunt2().getX(),
				this.getHoekPunt3().getX() };
		int[] yPoints = { this.getHoekPunt1().getY(), this.getHoekPunt2().getY(),
				this.getHoekPunt3().getY() };
		graphics.drawPolygon(xPoints, yPoints, 3);
		
	}
}
