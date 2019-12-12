package model;
import javax.persistence.*;
@Entity
@Table(name="Produit")
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id ;
private String description ; 
private double prix;
private int quantite;
@ManyToOne
@JoinColumn(name = "categorie_id") //tjr nom eloutani m3a eli bch norbto bih
private Categorie categorie;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Categorie getCategorie() {
	return categorie;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
public Produit(int id, String description, double prix, int quantite, Categorie categorie) {
	super();
	this.id = id;
	this.description = description;
	this.prix = prix;
	this.quantite = quantite;
	this.categorie = categorie;
}
public Produit() {
	super();
}



}
