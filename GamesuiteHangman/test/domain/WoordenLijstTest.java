package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import domain.exceptions.DatabaseException;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijstLeeg = new WoordenLijst();
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		
	}
	
	@Test
	public void getRandomWoord_moet_null_teruggeven_als_lijst_leeg() throws DatabaseException {
		//WoordenLijst woordenlijstl = new WoordenLijst();
		assertEquals(null,woordenlijstLeeg.getRandomWoord());
	}
	@Test
	public void Als_lijst_1_woord_bevat_geeft_dat_woord_terug() throws DatabaseException {
		ArrayList<String> lijst = new ArrayList<>();
		lijst.add("bob");
		assertEquals("bob", lijst.get(0));
	}
	@Test
	public void voegToe_moet_een_woord_toevoegen() throws DatabaseException {
		woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
		
		assertEquals(1,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() throws DatabaseException  {
		woordenlijstLeeg.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() throws DatabaseException {
		woordenlijstLeeg.voegToe("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() throws DatabaseException {
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
	}
	
}