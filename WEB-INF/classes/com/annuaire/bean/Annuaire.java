package com.annuaire.bean;

import java.util.ArrayList;

public class Annuaire {
		private ArrayList<Contact> contacts;
		private static long contactIdentifiant = 0;
		
		public Annuaire() {
			contacts = new ArrayList<Contact>();
		}
		
		public void setContacts(ArrayList<Contact> contacts) {
			this.contacts = contacts;
		}
		
		public ArrayList<Contact> getContacts(){
			return contacts;
		}
		
		public void add(Contact c) {
			contacts.add(c);
		}
		
		public int getSize() {
			return contacts.size();
		}
		
		public ArrayList<Contact> rechercher(String nom, String prenom, String telephone, String adresse, String mail) {
			ArrayList<Contact> resultat = new ArrayList<Contact>();
			for(Contact c : contacts) {
				if(!nom.isBlank() && !c.getNom().equals(nom))
					continue;
				if(!prenom.isBlank() && !c.getPrenom().equals(prenom))
					continue;
				if(!telephone.isBlank() && !c.getTelephone().equals(telephone))
					continue;
				if(!adresse.isBlank() && !c.getAdresse().equals(adresse))
					continue;
				if(!mail.isBlank() && !c.getMail().equals(mail))
					continue;
				resultat.add(c);
			}
			return resultat;
		}
		
		public Contact getContact(long identifiant) {
			for(Contact c : contacts) {
				if(c.getIdentifiant() == identifiant)
					return c;
			}
			return null;
		}
		
		public void supprimer(Contact c) { contacts.remove(c);}
		
		public void supprimer(long identifiant) {
			Contact c = getContact(identifiant);
			if(c == null) return;
			supprimer(c);
		}
		
		public void setContact(long identifiant, Contact c) {
			Contact cg = getContact(identifiant);
			if(c == null) return;
			cg.setNom(c.getNom());
			cg.setPrenom(c.getPrenom());
			cg.setTelephone(c.getTelephone());
			cg.setAdresse(c.getAdresse());
			cg.setMail(c.getMail());
		}
		
		public boolean isEmpty() {
			return contacts.isEmpty();
		}
		
		public boolean exist(long identifiant) {
			for(Contact c : contacts)
				if(c.getIdentifiant() == identifiant)
					return true;
			return false;
		}
		
		public boolean exist(Contact c) {
			for(Contact cc : contacts)
				if(cc.getIdentifiant() == c.getIdentifiant())
					return true;
			return false;
		}
		
		public static long newIdentifiant() {
			return contactIdentifiant++;
		}
}
