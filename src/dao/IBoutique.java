package dao;

import java.util.List;

import model.*;

public interface IBoutique {
 public void addProduit(Produit p);
 public List<Produit> getAllProduit();
 public List<Produit> getProduitByCategorie(Categorie c);
 public List<Categorie> getAllCategorie();
 public Categorie getCategorieById(int id);
 public User verifLogin(User u);
 public void signUp(User u);
 public void addCommande(Commande c);
 public void addLigneCommande(LigneCommande c);

}
