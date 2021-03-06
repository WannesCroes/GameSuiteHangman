package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exceptions.DomainException;
import domain.speler.Speler;
import domain.woord.WoordenLijst;

public class HangManTest {
	
	private HangMan hangman;
	private Speler geldigeSpeler;
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstInit;

	@Before
	public void setUp() throws Exception {
		geldigeSpeler = new Speler("naam");
		woordenlijstLeeg = new WoordenLijst(false);
		woordenlijstInit = new WoordenLijst(false);
		woordenlijstInit.voegToe("test");
	}

	@Test
	public void HangMan_moet_een_HangMan_spel_maken_en_initialiseren_voor_de_gegeven_speler_met_de_gegeven_woordenlijst() {
		hangman = new HangMan(geldigeSpeler, woordenlijstInit);
		assertEquals(geldigeSpeler, hangman.getSpeler());
		assertFalse(hangman.isGameOver());
		assertFalse(hangman.isGewonnen());
		assertEquals("_ _ _ _", hangman.getHint());
	}
	
	@Test (expected = DomainException.class)
	public void HangMan_moet_een_exception_gooien_als_gegeven_speler_null() {
		hangman = new HangMan(null, woordenlijstInit);
	}
	
	@Test (expected = DomainException.class)
	public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_null() {
		new HangMan(geldigeSpeler, null);
	}
	
	@Test (expected = DomainException.class)
	public void HangMan_moet_een_exception_gooien_als_gegeven_woordenlijst_leeg() {
		hangman = new HangMan(geldigeSpeler, woordenlijstLeeg);
	}
	
	// De testen voor wat er gebeurt als je een foutieve letter (null, leeg, meer dan 1 karakter) 
	// meegeeft, worden hier niet herhaald, die zitten al in de HintWoordTest	
	@Test
	public void raad_moet_volgende_zichtbaar_zetten_indien_fout_geraden(){
		hangman = new HangMan(geldigeSpeler, woordenlijstInit);
		char letter = 'a';
		assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
		
		hangman.raad(letter);
		assertEquals(13, hangman.getTekening().getAantalOnzichtbaar());
		assertFalse(hangman.isGameOver());
		assertFalse(hangman.isGewonnen());
	}
	
	@Test
	public void raad_mag_volgende_niet_zichtbaar_zetten_indien_juist_geraden(){
		hangman = new HangMan(geldigeSpeler, woordenlijstInit);
		char letter = 'e';
		assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
		
		hangman.raad(letter);
		assertEquals(14, hangman.getTekening().getAantalOnzichtbaar());
		assertFalse(hangman.isGameOver());
		assertFalse(hangman.isGewonnen());
	}
	
	@Test
	public void raad_mag_volgende_niet_zichtbaar_zetten_en_gewonnen_op_true_als_laatste_letter_juist_geraden(){
		HangMan hangmanOp1NaGeraden = new HangMan(geldigeSpeler, woordenlijstInit);
		hangmanOp1NaGeraden.raad('t');
		hangmanOp1NaGeraden.raad('e');
		
		hangmanOp1NaGeraden.raad('s');

		assertEquals(14, hangmanOp1NaGeraden.getTekening().getAantalOnzichtbaar());
		assertFalse(hangmanOp1NaGeraden.isGameOver());
		assertTrue(hangmanOp1NaGeraden.isGewonnen());
	}
	
	@Test
	public void raad_moet_volledige_afbeelding_zichtbaar_zetten_en_gameover_op_true_als_laatste_kans_fout_geraden(){
		HangMan hangmanNietGeradenEn13FouteAntwoorden = new HangMan(geldigeSpeler, woordenlijstInit);
		for(int i = 0; i < 13; i++){
			hangmanNietGeradenEn13FouteAntwoorden.raad('a');
		}

		hangmanNietGeradenEn13FouteAntwoorden.raad('o');
		
		assertEquals(0, hangmanNietGeradenEn13FouteAntwoorden.getTekening().getAantalOnzichtbaar());
		assertTrue(hangmanNietGeradenEn13FouteAntwoorden.isGameOver());
		assertFalse(hangmanNietGeradenEn13FouteAntwoorden.isGewonnen());
	}

}