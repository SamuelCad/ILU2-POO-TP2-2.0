package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		boolean etalDisponible = false;
		
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.");
		
		} else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			etalDisponible = controlPrendreEtal.resteEtals();
			
			if (!etalDisponible) {
				System.out.println("Désolé "+nomVendeur+" je n'ai plus "
						+ "d'étal qui ne soit pas déja occupé");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {		
		System.out.println("C'est parfait, il me reste un étal pour vous ! "
				+ "Il me faudrait quelques renseignements :");
		String produit=Clavier.entrerString("Quel produit souhaitez-vous vendre ?");
		int nbProduits=Clavier.entrerEntier("Combien souhaitez-vous vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numeroEtal);
		}
	}
	
}
