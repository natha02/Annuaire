package com.annuaire.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.annuaire.bean.Annuaire;
import com.annuaire.bean.Contact;

/**
 * Servlet implementation class RechercherContact
 */
public class RechercherContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherContact() {
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
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Controleur");
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String mail = request.getParameter("mail");
		
		Annuaire annuaire = (Annuaire) this.getServletContext().getAttribute("annuaire");
		ArrayList<Contact> contacts;
		
		// On recup les contacts trouvés lors de la recherche
		contacts = annuaire.rechercher(nom, prenom, telephone, adresse, mail);
		
		// On indique à la jsp que l'on a effectué une recherche
		request.setAttribute("recherche", true);
		// On donne au formulaire de recherche les paramètres de la recherche précédente
		request.setAttribute("nomRequest", nom);
		request.setAttribute("prenomRequest", prenom);
		request.setAttribute("telephoneRequest", telephone);
		request.setAttribute("adresseRequest", adresse);
		request.setAttribute("mailRequest", mail);

		
		// On oubli pas de donner le résultat à la JSP si il y en a !
		if(contacts.isEmpty())
			request.setAttribute("trouve", false);
		else {
			request.setAttribute("trouve", true);
			request.setAttribute("contacts", contacts);
		}
		request.setAttribute("requestServer", "RechercherContactJSP");
		dispatcher.forward(request, response);
		
	}

}
