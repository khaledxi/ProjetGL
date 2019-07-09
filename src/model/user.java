package model;

import java.sql.Date;

public class user {
	private int ID;
	private String nom,prenom,motp,adress;
	private Date dateN;
	private boolean directeur;
	// constructeur
	public user(int ID, String nom, String prenom, String motp, String adress, Date dateN, boolean directeur) {
		this.ID = ID;
		this.nom = nom;
		this.prenom = prenom;
		this.motp = motp;
		this.adress = adress;
		this.dateN = dateN;
		this.directeur = directeur;
	}
	
	//set and get
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getMotp() {
		return motp;
	}
	public void setMotp(String motp) {
		this.motp = motp;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getDateN() {
		return dateN;
	}
	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}
	public boolean isDirecteur() {
		return directeur;
	}
	public void setDirecteur(boolean directeur) {
		this.directeur = directeur;
	}
	
	
}
