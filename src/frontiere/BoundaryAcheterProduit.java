/*package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
	}
}*/


package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerString("Quel produit souhaitez-vous acheter ?");
		
		String nomVendeur = controlAcheterProduit.choixVendeur(produit);
			
		System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ nomVendeur);
		
		int nbProduitDemande = Clavier.entrerEntier("Bonjour "+nomAcheteur+"\n"+
												"Combien de "+produit+" voulez-vous acheter ?");
		int nbProduitRecu = controlAcheterProduit.acheterProduit(nomVendeur, nbProduitDemande);
		
		System.out.println(nomAcheteur+" a acheté "+ nbProduitRecu+" de "+produit+" à "+nomVendeur);	
	}
}
