package com.annuaire.bean;

public class Contact {
		private String nom, prenom, telephone, mail, adresse;
		private long identifiant;
		
		public Contact() {
			nom = "";
			prenom = "";
			telephone = "";
			mail = "";
			adresse = "";
			identifiant = Annuaire.newIdentifiant();
		}
		
		public Contact(String nom, String prenom, String telephone, String adresse, String mail) {
			this.nom = nom == null ? "" : nom;
			this.prenom = prenom == null ? "" : prenom;
			this.telephone = telephone == null ? "" : telephone;
			this.adresse = adresse == null ? "" : adresse;
			this.mail = mail == null ? "" : mail;
			identifiant = Annuaire.newIdentifiant();
		}
		
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		
		public long getIdentifiant() {
			return identifiant;
		}
		
		public Contact copy() {
			return new Contact(nom, prenom, telephone, adresse, mail);
		}
}
