package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoutiqueImp;
import model.Errors;
import model.User;

/**
 * Servlet implementation class Ajouter
 */
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueImp boutique ;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        boutique=new BoutiqueImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u= new User(0,request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("username"),request.getParameter("password"),request.getParameter("email"));
		boutique.signUp(u);
		Errors err =  new Errors("signed up", "you are signed up");
		Vector <Errors> error = new Vector<Errors>();
		HttpSession session = request.getSession();
		error.add(err);
		session.setAttribute("error", error);
		response.sendRedirect("Login.jsp");	}

}
