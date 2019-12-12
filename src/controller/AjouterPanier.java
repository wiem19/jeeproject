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
import model.*;

/**
 * Servlet implementation class AjouterPanier
 */
public class AjouterPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPanier() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Produit p = boutique.getProduitById(Integer.parseInt(request.getParameter("id")));
		boolean test = false;
		int val = 0 ;
		if(session.getAttribute("panier")!=null)
		{
			Panier panier= (Panier)session.getAttribute("panier");
			for(int i = 0 ; i< panier.getListpanier().size(); i++)
			{	
				if (panier.getListpanier().get(i).getP().getId()==id)
				{
					test = true; 
					val = i ;
				}
			}
			if ( test )
				panier.getListpanier().get(val).setQuantite(panier.getListpanier().get(val).getQuantite()+1);					
			else {
				LignePanier lp = new LignePanier(p, 1);
				panier.getListpanier().add(lp);		
			}
			response.sendRedirect("AfficherPanier");
		}
		else {
			List<LignePanier> listeligne = new ArrayList<LignePanier>();
			LignePanier ligne = new LignePanier(p, 1);
			listeligne.add(ligne);
			Panier newpanier = new Panier(listeligne);
			
			session.setAttribute("panier", newpanier);
			response.sendRedirect("AfficherPanier");
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
