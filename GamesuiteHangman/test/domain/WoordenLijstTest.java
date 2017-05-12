package domain;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import domain.exceptions.DomainException;
import domain.woord.WoordenLijst;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijst;
	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijst = new WoordenLijst(false);
	}
	
	@After
	public void breakDown() {
		woordenlijst.reset();
	}
	
	@Test
	public void getRandomWoord_moet_null_teruggeven_als_lijst_leeg() {
		//WoordenLijst woordenlijstl = new WoordenLijst();
		assertEquals(null, woordenlijst.getRandomWoord());
	}
	@Test
	public void Als_lijst_1_woord_bevat_geeft_dat_woord_terug() {
		woordenlijst.voegToe(geldigeWoorden.get(0));
		assertEquals("test", woordenlijst.getRandomWoord());
	}
	@Test
	public void voegToe_moet_een_woord_toevoegen() {
		woordenlijst.voegToe(geldigeWoorden.get(0));
		assertEquals("test", woordenlijst.getRandomWoord());
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() {
		woordenlijst.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() {
		woordenlijst.voegToe("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() {
		woordenlijst.voegToe(geldigeWoorden.get(0));
		woordenlijst.voegToe(geldigeWoorden.get(1));
		woordenlijst.voegToe(geldigeWoorden.get(2));
		
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijst.voegToe(woordAlInLijst);
	}
	@Test
	public void getRandomWoord_geeft_random_woord(){
		woordenlijst.voegToe(geldigeWoorden.get(0));
		woordenlijst.voegToe(geldigeWoorden.get(1));
		woordenlijst.voegToe(geldigeWoorden.get(2));
	
		assertNotNull(woordenlijst.getRandomWoord());
	}	
}