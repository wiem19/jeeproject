package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoutiqueImp;
import model.Panier;
import model.Produit;

/**
 * Servlet implementation class SupprimerPanier
 */
public class SupprimerPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPanier() {
        super();
        boutique=new BoutiqueImp();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Produit p = boutique.getProduitById(Integer.parseInt(request.getParameter("id")));
		Panier panier= (Panier)session.getAttribute("panier");
		for(int i = 0 ; i< panier.getListpanier().size(); i++)
		{	
			if (panier.getListpanier().get(i).getP().getId()==id)
				panier.getListpanier().remove(i);
		}
		response.sendRedirect("AfficherPanier");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
