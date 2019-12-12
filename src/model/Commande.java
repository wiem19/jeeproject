package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Commande")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id ;
@OneToMany(cascade=CascadeType.ALL,mappedBy="cde")
List<LigneCommande> lignecommande ;

String date ; 

@ManyToOne
@JoinColumn(name = "user_id") //tjr nom eloutani m3a eli bch norbto bih
private User user;

public Commande(int id, String date, User user) {
	super();
	this.id = id;
	lignecommande= new ArrayList<LigneCommande>();
	this.date = date;
	this.user = user;
}
public Commande() {
	super();
	lignecommande= new ArrayList<LigneCommande>();
}
public void addLigne(LigneCommande li) {
	lignecommande.add(li);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<LigneCommande> getLignecommande() {
	return lignecommande;
}
public void setLignecommande(List<LigneCommande> lignecommande) {
	this.lignecommande = lignecommande;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
