package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import personnages.Gaulois;
import villagegaulois.Village;


class ControlAfficherVillageTest {
	
	private ControlAfficherVillage control;
	private Village village;

	
	@BeforeEach
	public void initTest() {
		village = new Village("le village", 2, 10);
		Chef chef = new Chef("Abraracourcix", 1 ,village);
		village.setChef(chef);
		control = new ControlAfficherVillage(village);	

	}
		
	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		Gaulois bonemine = new Gaulois("Bonemine", 4);
		Druide panoramix = new Druide("Panoramix", 2, 4, 10);
		Gaulois obelix = new Gaulois("Obelix", 8);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(panoramix);
		village.ajouterHabitant(obelix);
		
		String sortieTest = Arrays.toString(control.donnerNomsVillageois());
		String sortieAttendu = "[Abraracourcix, Bonemine, le druide Panoramix]";
		
		assertNotNull(control.donnerNomsVillageois());
		assertEquals(sortieTest, sortieAttendu);
	}

	@Test
	void testDonnerNomVillage() {
		assertNotNull(control.donnerNomVillage());
		assertEquals(control.donnerNomVillage(), "le village");
	}

	@Test
	void testDonnerNbEtals() {
		assertNotNull(control.donnerNbEtals());
		assertEquals(control.donnerNbEtals(), 10);
	}

}
