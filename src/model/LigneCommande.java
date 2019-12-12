package model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LigneCommande {
	Produit p ;
	int quantite;
	
	@ManyToOne
	@JoinColumn(name="cde_id")
	Commande cde;

	public LigneCommande(Produit p, int quantite, Commande cde) {
		super();
		this.p = p;
		this.quantite = quantite;
		this.cde = cde;
	}
	public LigneCommande() {

	}
	public Produit getP() {
		return p;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Commande getCde() {
		return cde;
	}
	public void setCde(Commande cde) {
		this.cde = cde;
	}
	
	
}
