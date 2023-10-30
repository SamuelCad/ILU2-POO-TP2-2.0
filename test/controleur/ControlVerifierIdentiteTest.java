package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	
	private ControlVerifierIdentite control;
	private Village village;
	
	@BeforeEach
	protected void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		control = new ControlVerifierIdentite(village);	
	
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(control.verifierIdentite("Asterix"));
		Gaulois asterix = new Gaulois("Asterix", 6);
		village.ajouterHabitant(asterix);
		assertTrue(control.verifierIdentite("Asterix"));
	}

}
