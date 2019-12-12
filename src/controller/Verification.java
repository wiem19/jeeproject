package controller;
import dao.*;
import model.Errors;
import model.User;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Verification
 */
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        boutique=new BoutiqueImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Authentification.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User(request.getParameter("login"), request.getParameter("password"));
		if (boutique.verifLogin(u)==null)
		{
			Errors err =  new Errors("notExist", "Login ou mot de passe incorrecte");
			Vector <Errors> error = new Vector<Errors>();
			HttpSession session = request.getSession();
			error.add(err);
			session.setAttribute("error", error);
			response.sendRedirect("Login.jsp");
		
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("Commande");
		}
	}

}
