package model;

import java.util.List;

public class LignePanier {
	Produit p ;
	int quantite;
	public LignePanier(Produit p, int quantite) {
		super();
		this.p = p;
		this.quantite = quantite;
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
	public LignePanier() {

	}
}
