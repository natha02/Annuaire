package com.annuaire.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.annuaire.bean.Annuaire;
import com.annuaire.bean.Contact;

/**
 * Servlet implementation class CreerContact
 */
public class CreerContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerContact() {
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
		
		//on récupère le context de controleur
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Controleur");
		
		/*
		 * on initialise et récupère les paramètre
		 */
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String mail = request.getParameter("mail");
		
		// On  l'ajoute et on demande à afficher la liste des contacts
		Contact c = new Contact(nom, prenom, telephone, adresse, mail);
		Annuaire annuaire = (Annuaire) this.getServletContext().getAttribute("annuaire");
		annuaire.add(c);
		request.setAttribute("requestServer", "AfficherContactJSP");
		dispatcher.forward(request, response);
	}

}
