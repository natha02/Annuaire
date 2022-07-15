package com.annuaire.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.annuaire.bean.Annuaire;

/**
 * Servlet implementation class SupprimerContact
 */
public class SupprimerContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		long identifiant = Long.parseLong(request.getParameter("identifiant"));
		//création d'une nouvelle objet et on le cast pour dire que c'est type Annuaire et on récupère le contexte annuaire
		Annuaire annuaire = (Annuaire) this.getServletContext().getAttribute("annuaire");
		annuaire.supprimer(identifiant); // La suppression ne provoque pas d'erreur si le contact n'existe plus
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Controleur");
		//name : requestServer , value : AfficherContactJSP
		request.setAttribute("requestServer", "AfficherContactJSP");
		dispatcher.forward(request, response);
		
	}

}
