package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private ControlPrendreEtal control;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	
	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 2);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		control = new ControlPrendreEtal(controlVerifierIdentite, village);
		
	}
	
	
	@BeforeEach
	public void initVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		Gaulois obelix = new Gaulois("Obelix", 8);
		Gaulois idefix = new Gaulois("Idefix", 8);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(obelix);
		
	}
	
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		assertTrue(control.resteEtals());
		
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		Gaulois obelix = new Gaulois("Obelix", 8);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(obelix);
		village.installerVendeur(bonemine, "fleurs", 5);
		village.installerVendeur(obelix, "rhum", 3);
		
		/*
		 * Le nombre max d'étal du village est égale à 2.
		 * */
		assertFalse(control.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		int indiceEtal = control.prendreEtal("Bonemine", "fleurs", 5);
		int indiceEtal2 = control.prendreEtal("Obelix", "rhum", 6);
		assertNotEquals(indiceEtal, -1);
		assertEquals(indiceEtal, 1);
		assertEquals(indiceEtal2, 2);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		village.ajouterHabitant(bonemine);
		
		assertTrue(control.verifierIdentite("Bonemine"));
		assertFalse(control.verifierIdentite("bonemine"));
		assertFalse(control.verifierIdentite("Idefix"));
		
	}

}


