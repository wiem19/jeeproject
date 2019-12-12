package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoutiqueImp;
import model.Categorie;
import model.Produit;

/**
 * Servlet implementation class RechercheProduit
 */
public class RechercheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheProduit() {
        super();
        boutique=new BoutiqueImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("cat"));
		Categorie c1 = boutique.getCategorieById(id);
		List<Produit> p = boutique.getProduitByCategorie(c1);
		List<Categorie> c = boutique.getAllCategorie();
		request.setAttribute("produit", p);
		request.setAttribute("categorie", c);

		request.getRequestDispatcher("Boutique.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
