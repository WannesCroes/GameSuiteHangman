package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		Cirkel cirkelAnder = new Cirkel(middelpunt, 0);
	}
	
	@Test(expected = DomainException.class)
	public void Middelpunt_is_null(){
		Cirkel cirkelAnder = new Cirkel(null, radius);
	}
	public void equals_moet_false_Teruggeven_als_punt_niet_gelijk_is(){
		Punt punt = new Punt(100,300);
		Cirkel cirkelAnder= new Cirkel(punt, radius);
		assertFalse(cirkel.equals(cirkelAnder));
	}
	public void equals_geeft_true_als_punt_gelijk_is(){
		Cirkel cirkelAnder = new Cirkel(middelpunt, radius);
		assertTrue(cirkel.equals(cirkelAnder));
		
			}
	
}
