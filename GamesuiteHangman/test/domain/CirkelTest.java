package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exceptions.DomainException;
import domain.vorm.Cirkel;
import domain.vorm.Omhullende;
import domain.vorm.Punt;

public class CirkelTest {

	private int radius;
	private Punt middelpunt;
	private Cirkel cirkel;
	
	@Before
	public void setUp() throws Exception{
		radius = 5;
		middelpunt = new Punt(200, 200);
		cirkel = new Cirkel(middelpunt, radius);
	}
	
	@Test
	public void Cirkel_maken_juist_straal_en_middelpunt(){
		Cirkel cirkelAnder = new Cirkel(middelpunt, radius);
		assertEquals(middelpunt, cirkelAnder.getMiddelpunt());
		assertEquals(radius, cirkelAnder.getRadius());
	}
	
	@Test(expected = DomainException.class)
	public void Straal_is_0(){
		new Cirkel(middelpunt, 0);
	}
	
	@Test(expected = DomainException.class)
	public void Middelpunt_is_null(){
		new Cirkel(null, radius);
	}
	@Test
	public void equals_moet_false_Teruggeven_als_punt_niet_gelijk_is(){
		Punt punt = new Punt(100,300);
		Cirkel cirkelAnder= new Cirkel(punt, radius);
		assertFalse(cirkel.equals(cirkelAnder));
	}
	@Test
	public void equals_geeft_true_als_punt_gelijk_is(){
		Cirkel cirkelAnder = new Cirkel(middelpunt, radius);
		assertTrue(cirkel.equals(cirkelAnder));
		
			}
	
	@Test
	public void getOmhullende_moet_juiste_waarde_geven(){
		Punt middelpunt = new Punt(200,200);
		int radius = 20;
		Punt Linksboven = new Punt(180,180);
		Cirkel cirkel = new Cirkel(middelpunt, radius);
		Omhullende omhullende = new Omhullende(Linksboven, 40,40);
		assertEquals(cirkel.getOmhullende(),omhullende );
	}
	
}
