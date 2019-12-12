package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.*;

public class BoutiqueImp implements IBoutique{
	EntityManager em ; 
	public BoutiqueImp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ali");
		em=factory.createEntityManager();
	}
	public void addProduit(Produit p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public List<Produit> getAllProduit() {
		em.getTransaction().begin();
		Query q = em.createQuery("select e from Produit e");
		List<Produit> l = q.getResultList();
		em.getTransaction().commit();
		return l;
	}
	public List<Produit> getProduitByCategorie(Categorie c) {
		em.getTransaction().begin();
		Query q = em.createQuery("select e from Produit e where e.categorie.id = "+c.getId());
		List<Produit> l = q.getResultList();
		em.getTransaction().commit();
		return l;
	}
	 public List<Categorie> getAllCategorie(){
		 em.getTransaction().begin();
			Query q = em.createQuery("select e from Categorie e");
			List<Categorie> l = q.getResultList();
			em.getTransaction().commit();
			return l;
	 }
	 public Categorie getCategorieById(int id) {
		 	em.getTransaction().begin();
			Query q = em.createQuery("select e from Categorie e where e.id = :idd");
			q.setParameter("idd", id).getSingleResult();
			//q.setParameter(1, id);
			Categorie l = (Categorie)q.getSingleResult();
			em.getTransaction().commit();
			return l;
		 
	 }
	 
	 public Produit getProduitById(int id) {
		 	em.getTransaction().begin();
			Query q = em.createQuery("select e from Produit e where e.id = :idd");
			q.setParameter("idd", id).getSingleResult();
			//q.setParameter(1, id);
			Produit l = (Produit) q.getSingleResult();
			em.getTransaction().commit();
			return l;
		 
	 }
	 public User verifLogin(User u) {	 
		 em.getTransaction().begin();
			Query q = em.createQuery("select e from User e where e.username = :idd and e.password = :ps");
			q.setParameter("idd", u.getUsername());
			q.setParameter("ps", u.getPassword());
			List<User> l = q.getResultList();
			em.getTransaction().commit();
			if(l.size()==0)
			{
				return null ;
			}else {
			return l.get(0);
			}
	 }
		public void signUp(User u) {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}

		 public void addCommande(Commande c) {
				em.getTransaction().begin();
				em.persist(c);
				em.getTransaction().commit();
		 }
		 public void addLigneCommande(LigneCommande c) {
				em.getTransaction().begin();
				em.persist(c);
				em.getTransaction().commit();
		 }
}
