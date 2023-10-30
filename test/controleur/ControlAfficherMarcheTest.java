package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	private ControlAfficherMarche control;
	private Village village;

	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		control = new ControlAfficherMarche(village);	

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
	void testControlAfficherMarche() {
		assertNotNull(control);
	}

	@Test
	void testDonnerInfosMarche() {
		String sortieAttendu = "[Bonemine, 5, fleurs, Obelix, 7, rhum]";
		String sortieTest = Arrays.toString(control.donnerInfosMarche());
	
		assertNotNull(control.donnerInfosMarche());
		assertEquals(sortieTest, sortieAttendu);

	}

}
