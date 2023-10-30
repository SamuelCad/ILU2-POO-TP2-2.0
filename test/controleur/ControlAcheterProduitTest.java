package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	private ControlAcheterProduit control;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		control = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	
	}
	
	@BeforeEach
	public void initVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		Gaulois obelix = new Gaulois("Obelix", 8);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(obelix);
		village.installerVendeur(bonemine, "fleurs", 5);
		village.installerVendeur(obelix, "rhum", 7);
		
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(control);
	}
	
	@Test
	void testAfficherVendeur() {
		assertNotNull(control.afficherVendeur("fleurs"));
		assertEquals(control.afficherVendeur("fleurs"),"1 - Bonemine");
		assertEquals(control.afficherVendeur("rose"),"");
	}
	

	@Test
	void testChoixVendeur() {
		assertEquals(control.choixVendeur(1, "fleurs"), "Bonemine");
	}

	@Test
	void testAcheterProduit() {
		assertEquals(control.acheterProduit("Bonemine", 3),3);
		assertEquals(control.acheterProduit("Bonemine", 3),2);
		assertEquals(control.acheterProduit("Idefix", 3),-1);
	}

	@Test
	void testVerifProduit() {
		assertTrue(control.verifProduit("fleurs"));
		assertTrue(control.verifProduit("rhum"));
		assertFalse(control.verifProduit("rose"));
	}

}












