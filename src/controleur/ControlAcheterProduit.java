/*package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
}*/


package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String choixVendeur(String produit){
		StringBuilder listeVendeur = new StringBuilder();
		System.out.println("Chez quel commerçant voulez-vous acheter des "+produit +" ?");
		
		Gaulois[] tabVendeur = village.rechercherVendeursProduit(produit);
		for (int i = 0; i < tabVendeur.length; i++) {
			Gaulois gaulois = tabVendeur[i];
			listeVendeur.append(i+1+" - "+gaulois.getNom());
			
		}
		System.out.println(listeVendeur.toString());
		int numVendeur=Clavier.entrerEntier("");
		String nomVendeur = tabVendeur[numVendeur-1].getNom();
		
		
		return nomVendeur;
		
	}
	public int acheterProduit(String nomVendeur, int nbproduit) {
		
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteAchete=etal.acheterProduit(nbproduit);
		return quantiteAchete;
		
	}
}
