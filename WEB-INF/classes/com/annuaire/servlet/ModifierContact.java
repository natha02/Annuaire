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
 * Servlet implementation class ModifierContact
 */
public class ModifierContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierContact() {
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
		//on récupère le contexte controleur pour gerer tous
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Controleur");
		//on initialise identifiant et on récupère le paramètre et le stocke
		long identifiant = Long.parseLong(request.getParameter("identifiant"));
		//on crée une nouvelle objet annuaire et on lui donne les attribut nécessaire de annuaire
		Annuaire annuaire = (Annuaire) this.getServletContext().getAttribute("annuaire");

		// On edite le contact en récupérant les paramètres
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String mail = request.getParameter("mail");
		//nouvelle objet qu'on a nommé c et contenant tous les attributs utiles pour la modifications
		Contact c = new Contact(nom, prenom, telephone, adresse, mail);
			
		// si le contact existe encore
		if(annuaire.exist(identifiant))
			annuaire.setContact(identifiant, c); // On le modifie
		else
			annuaire.add(c); // Si non on crée un nouveau contact avec ses infos
			
		request.setAttribute("requestServer", "AfficherContactJSP");
		dispatcher.forward(request, response);
	}

}
