package model;

import javax.persistence.*;
@Entity
@Table(name="Categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
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
	public Categorie(int id, String nom) {
		super();
		this.id = id;
		this.description = nom;
	}
	public Categorie() {
		super();
	} 
	
}
