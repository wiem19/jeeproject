package model;
import javax.persistence.*;
@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id ;
private String username;
private String password;
private String email;
private String nom ; 
private String prenom ;
public User(int id, String username, String password, String email, String nom, String prenom) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.nom = nom;
	this.prenom = prenom;
}
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;

}
public User() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
} 





}
