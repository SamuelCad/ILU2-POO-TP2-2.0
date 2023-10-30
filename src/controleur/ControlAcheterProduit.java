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

	public String afficherVendeur(String produit){
		StringBuilder listeVendeur = new StringBuilder();
		
		Gaulois[] tabVendeur = village.rechercherVendeursProduit(produit);
		for (int i = 0; tabVendeur!=null && i < tabVendeur.length ; i++) {
			Gaulois gaulois = tabVendeur[i];
			listeVendeur.append(i+1+" - "+gaulois.getNom());
			
		}
		
		return listeVendeur.toString();
	}
	
	public String choixVendeur(int numVendeur, String produit) {
		Gaulois[] tabVendeur = village.rechercherVendeursProduit(produit);
		String nomVendeur = tabVendeur[numVendeur-1].getNom();

		return nomVendeur;
	}
	
	public int acheterProduit(String nomVendeur, int nbproduit) {
		int quantiteAchete= -1;
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etal!=null) {
			quantiteAchete=etal.acheterProduit(nbproduit);
		}
		return quantiteAchete;
		
	}
	
	public boolean verifProduit(String produit) {
		boolean produitExiste = false;
		Gaulois[] tabVendeur = village.rechercherVendeursProduit(produit);
		if (tabVendeur!=null) {
			produitExiste = true; 
		}		
		
		return produitExiste;
		
	}
}
