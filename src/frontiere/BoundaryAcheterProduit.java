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
		
		if (controlAcheterProduit.verifProduit(produit)) {
			System.out.println("Chez quel commerçant voulez-vous acheter des "+produit +" ?");
			String listeVendeurs = controlAcheterProduit.afficherVendeur(produit);
			System.out.println(listeVendeurs);

			int numVendeur=Clavier.entrerEntier("");
			String nomVendeur = controlAcheterProduit.choixVendeur(numVendeur, produit);
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ nomVendeur);
			
			afficheQuantiteAcheter(nomAcheteur, nomVendeur, produit);
			
				
		}else {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}
	}
	
	public void afficheQuantiteAcheter(String nomAcheteur, String nomVendeur, String produit) {
		int nbProduitDemande = Clavier.entrerEntier("Bonjour "+nomAcheteur+"\n"+"Combien de "+produit+" voulez-vous acheter ?");
		int nbProduitRecu = controlAcheterProduit.acheterProduit(nomVendeur, nbProduitDemande);
		
		if (nbProduitRecu==nbProduitDemande) {
			System.out.println(nomAcheteur+" a acheté "+ nbProduitRecu+" de "+produit+" à "+nomVendeur);				
		} 
		
		else if (nbProduitRecu==0) {
			System.out.println(nomAcheteur+" veut acheter "+nbProduitDemande+" "+produit+", malheureusement il n’y en a plus !");
		}
		
		else {
			System.out.println(nomAcheteur+ " veut acheter "+nbProduitDemande+" "+produit+
					", malheureusement "+nomVendeur+ " n'en a plus que "+nbProduitRecu+". ");
			System.out.println(nomAcheteur+ " achète tout le stock de "+nomVendeur);
		}
	}
}
