package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private ControlLibererEtal control;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	
	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		control = new ControlLibererEtal(controlTrouverEtalVendeur);	
		
	}
	
	@BeforeEach
	public void initVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		Gaulois obelix = new Gaulois("Obelix", 8);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(obelix);
		village.installerVendeur(bonemine, "fleurs", 5);
		
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(control);
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testIsVendeur() {
		assertTrue(control.isVendeur("Bonemine"));
		assertFalse(control.isVendeur("Obelix"));
	}

	@Test
	void testLibererEtal() {
		assertTrue(control.isVendeur("Bonemine"));
		control.libererEtal("Bonemine");
		assertFalse(control.isVendeur("Bonemine"));
		
		assertEquals(control.libererEtal("AZ"), null);

	}

}
