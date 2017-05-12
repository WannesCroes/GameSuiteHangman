package domain;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.vorm.Punt;
import domain.vorm.Rechthoek;
import domain.vorm.Vorm;
import ui.UiException;

public class TekeningHangManTest {
	@Before
	public void SetUp(){
	}
	
	@Test
	public void Maakt_tekening_met_naam_hangman_en_18_vormen_waarvan_14_onzichtbaar(){
		TekeningHangMan tekening = new TekeningHangMan();
		assertEquals(14, tekening.getAantalOnzichtbaar());
		
	}
	@Test
	public void ZetVolgendeZichtbaar_moet_eerstvolgende_onzichtbare_vorm_zichtbaar_maken(){
		TekeningHangMan tekening = new TekeningHangMan();
		tekening.zetVolgendeZichtbaar();
		assertEquals(13, tekening.getAantalOnzichtbaar());
	}
	@Test (expected = UiException.class)
	public void ZetVolgendeZichtbaar_gooit_exception_als_alle_vormen_zichtbaar() {
		TekeningHangMan tekening = new TekeningHangMan();
		for(int i = 0; i != 15; i++){
		tekening.zetVolgendeZichtbaar();
		}
	}
	@Test
	public void reset_maakt_alle_vormen_buiten_de_galg_onzichtbaar(){
		TekeningHangMan tekening = new TekeningHangMan();
		boolean condition = true;
		for(int i = 4; i < 18 ; i++){
			condition &= !(tekening.getVorm(i).isZichtbaar());
		}
		Assert.assertTrue(condition);
	}

	@Test (expected = UiException.class)
	public void voegToe_moet_exception_gooien(){
		TekeningHangMan tekening = new TekeningHangMan();
		Vorm vorm = new Rechthoek(new Punt(10, 350), 300, 40);
 
		tekening.voegToe(vorm);
	}
	@Test (expected = UiException.class)
	public void verwijder_moet_een_exception_gooien(){
		TekeningHangMan tekening = new TekeningHangMan();
		Vorm vorm = new Rechthoek(new Punt(10, 350), 300, 40);
 
		tekening.verwijder(vorm);
	}
}
