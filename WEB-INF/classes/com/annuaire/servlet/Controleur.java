package com.annuaire.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import com.annuaire.bean.Annuaire;
import com.annuaire.bean.Contact;

/**
 * Servlet implementation class Controleur
 */
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	System.out.println("Init Annuaire début...");
    	
    	// annuaire
    	Annuaire annuaire = new Annuaire();
    	
    	//Création de notre factory
    	XMLInputFactory factory = XMLInputFactory.newInstance();

    	//On utilise notre fichier annuaire
    	File file = new File("annuaire.xml");
    	
    	try {
    		XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(file));
    		
    		// champs à lire pour chaque contact
    		String nom = "", prenom = "", telephone = "", adresse = "", mail = "";
			String data = ""; // Contiendra les données des champs juste au dessus
    		while (reader.hasNext()) {
    			// Récupération de l'événement
    			int type = reader.next();
    			String end = ""; // Par défaut, la balise fermante est "vide"
    			// Switch en fonction du type d'évenement
    			switch (type) {
    				case XMLStreamReader.END_ELEMENT:
    					end = reader.getLocalName(); // On récupère le nom de la balise fermante en cours
    					break;

    				case XMLStreamReader.CHARACTERS:
    					// Si il y a des données à lire :
    					data = reader.getText(); 
    					if(data == null) data = ""; // Si non, il n'y a pas de données
    					break;
    			}
    			
    			// On regarde que faire lorsque l'on ferme une balise, c'est à dire, on assigne la dernière donnée lue
    			// par le parseur au champ correspondant à la balise fermante, on oubli pas de "vider" la donnée
    			// après son utilisation.
    			
    			// Si la balise fermante est un contact, on créé un nouveau contact avec les champs définis lors
    			// du parcours du xml, on oubli pas de "vider" les champs temp (ainsi que la dernière donnée lue par le parseur)
    			switch(end) {
    				case "NOM":
    					nom = data; // Sauvegarde de la donnée dans son champ correspondant
    					data = ""; // On vide la donnée
    					break;
    				case "PRENOM":
    					prenom = data;
    					data = "";
    					break;
    				case "TELEPHONE":
    					telephone = data;
    					data = "";
    					break;
    				case "ADRESSE":
    					adresse = data;
    					data = "";
    					break;
    				case "MAIL":
    					mail = data;
    					data = "";
    					break;
    					
    				case "CONTACT":
    					// Création du contact et ajout de celui-ci dans l'annuaire
    					Contact c = new Contact(nom, prenom, telephone, adresse, mail);
    					annuaire.add(c);
    					// Vidage des champs temporaires
    					nom = "";
    					prenom = "";
    					telephone = "";
    					adresse = "";
    					mail = "";
    					// On vide la dernière donnée lue par le parseur
    					data = "";
    					break;
    			}
    		}
    	} catch (FileNotFoundException e) {
    		System.err.println("annuaire.txt not found");
    	} catch (XMLStreamException e) {
    		e.printStackTrace();
    		System.err.println("can't read annuaire.txt");
    	}
    	
    	// On sauvegarde l'annuaire dans le contexte de l'application
    	this.getServletContext().setAttribute("annuaire", annuaire);
    	
    	
    	System.out.println("Init Annuaire fin... done !");
    }
    
    public void destroy() {
    	// ------ Sauvegarde de l'annuaire en XML ---------------------
    	
    	//Création de notre factory d'écriture
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        
      //On crée notre objet qui va servir à écrire dans notre fichier      
        try(FileOutputStream fos = new FileOutputStream(new File("annuaire.xml"))) {
           //nous créons notre objet qui va écrire dans notre fichier, en spécifiant l'encodage
           XMLStreamWriter xsw = xof.createXMLStreamWriter(fos, "UTF-8");
           
           
           xsw.writeStartDocument("UTF-8", "1.0");
           xsw.writeDTD("<!DOCTYPE ANNUAIRE SYSTEM \"annuaire.dtd\">");
           xsw.writeStartElement("ANNUAIRE");
           
           Annuaire annuaire = (Annuaire) this.getServletContext().getAttribute("annuaire");
           for(Contact c : annuaire.getContacts()) {
        	   xsw.writeStartElement("CONTACT");
        	   
        	   		xsw.writeStartElement("NOM");
        	   			xsw.writeCharacters(c.getNom());
        	   		xsw.writeEndElement();
        	   		
	        	   	xsw.writeStartElement("PRENOM");
	    	   			xsw.writeCharacters(c.getPrenom());
	    	   		xsw.writeEndElement();
	    	   		
	    	   		xsw.writeStartElement("TELEPHONE");
    	   				xsw.writeCharacters(c.getTelephone());
    	   			xsw.writeEndElement();
    	   			
    	   			String adresse = c.getAdresse();
    	   			if(!adresse.isBlank()) {
    	   				xsw.writeStartElement("ADRESSE");
	   						xsw.writeCharacters(adresse);
	   					xsw.writeEndElement();
    	   			}
	   				
	   				xsw.writeStartElement("MAIL");
   						xsw.writeCharacters(c.getMail());
   					xsw.writeEndElement();
        	   		
        	   xsw.writeEndElement();
           }
           xsw.writeEndElement();
           xsw.writeEndDocument();
           //Très important, on doit invoquer les méthodes flush() et close()
           //pour rendre l'écriture effective
           xsw.flush();
           xsw.close();
        } catch (IOException e) {
        	System.err.println("can't create annuaire.txt");
        } catch (XMLStreamException e) {
        	System.err.println("can't write in annuaire.txt");
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;
		String requestServer = (String) request.getAttribute("requestServer");
		String requestUser = request.getParameter("requestUser");
		
		// On traite toujours les redirections du serveur en premier
		String redirection = requestServer != null ? requestServer : requestUser;
		
		
		switch(redirection){
		/*
		 * redirection vers nos servlets
		 */
		case "CreerContact":
			dispatcher = this.getServletContext().getRequestDispatcher("/CreerContact");
			dispatcher.forward(request, response);
			break;
			
		case "RechercherContact":
			dispatcher = this.getServletContext().getRequestDispatcher("/RechercherContact");
			dispatcher.forward(request, response);
			break;
			
		case "SupprimerContact":
			dispatcher = this.getServletContext().getRequestDispatcher("/SupprimerContact");
			dispatcher.forward(request, response);
			break;
			
		case "ModifierContact":
			dispatcher = this.getServletContext().getRequestDispatcher("/ModifierContact");
			dispatcher.forward(request, response);
			break;
		
		/*
		 * vers nos vues jsp	
		 */
		case "CreerContactJSP":
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/creerContact.jsp");
			dispatcher.forward(request, response);
			break;
		
		case "RechercherContactJSP":
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/rechercherContact.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "ModifierContactJSP":
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierContact.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "AfficherContactJSP":
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/afficherContact.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "IndexJSP":
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
			break;
			
		default:
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

}
