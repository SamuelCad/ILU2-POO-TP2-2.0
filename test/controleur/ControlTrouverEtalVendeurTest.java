package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	
	private ControlTrouverEtalVendeur control;
	private Village village;
	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		control = new ControlTrouverEtalVendeur(village);	
	
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
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNotNull(control.trouverEtalVendeur("Bonemine"));
		assertNull(control.trouverEtalVendeur("Obelix"));
		assertNull(control.trouverEtalVendeur("Idefix"));
	}

}
