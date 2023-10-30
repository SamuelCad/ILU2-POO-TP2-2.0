package controleur;

import static org.junit.jupiter.api.Assertions.*;
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlEmmenagerTest {
	
	private ControlEmmenager control;
	private Village village;
	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		control = new ControlEmmenager(village);	
	
	}
	
	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		assertFalse(control.isHabitant("Asterix"));
		control.ajouterGaulois("Asterix", 12);
		assertTrue(control.isHabitant("Asterix"));
		
	}

	@Test
	void testAjouterDuide() {
		control.ajouterDruide("Panoramix", 3, 4, 8);
		assertTrue(village.trouverHabitant("Panoramix")instanceof Druide);
	}

	@Test
	void testAjouterGaulois() {
		control.ajouterGaulois("Asterix", 5);
		assertTrue(village.trouverHabitant("Asterix")instanceof Gaulois);
	}

}
