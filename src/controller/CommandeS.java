package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoutiqueImp;
import model.Commande;
import model.LigneCommande;
import model.LignePanier;
import model.Panier;
import model.User;

/**
 * Servlet implementation class Commande
 */
public class CommandeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeS() {
        super();
        // TODO Auto-generated constructor stub
        boutique=new BoutiqueImp();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Panier panier= (Panier)session.getAttribute("panier");
		Commande c  = new Commande();
		List<LigneCommande> listecom = new ArrayList<LigneCommande>();
		if(panier.getListpanier().size()>0) {
		for ( int i = 0 ;i<panier.getListpanier().size();i++)
		{
			LigneCommande lc = new LigneCommande(panier.getListpanier().get(i).getP(), panier.getListpanier().get(i).getQuantite(),c);
			listecom.add(lc);		
		}
		c.setDate("now");
		c.setLignecommande(listecom);
		User user= (User)session.getAttribute("user");
		c.setUser(user);
		boutique.addCommande(c);
		for(LigneCommande lc : listecom)
		boutique.addLigneCommande(lc);	
		response.sendRedirect("commande.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
