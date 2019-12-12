package model;

import java.util.List;

public class Panier {
	List<LignePanier> listpanier ;
	
	public Panier(List<LignePanier> listpanier) {
		super();
		this.listpanier = listpanier;
	}

	public List<LignePanier> getListpanier() {
		return listpanier;
	}

	public void setListpanier(List<LignePanier> listpanier) {
		this.listpanier = listpanier;
	}
	

	public Panier() {

	}

}
