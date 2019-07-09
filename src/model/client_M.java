package model;

import java.sql.Date;

public class client_M {
	private String nom,prenom,lieuN,numP,adress;
	private Date dateN;
	//construceur
	public client_M( String nom, String prenom, String lieuN, String numP, String adress, Date dateN) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.lieuN = lieuN;
		this.numP = numP;
		this.adress = adress;
		this.dateN = dateN;
	}
	//set et get
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
	public String getLieuN() {
		return lieuN;
	}
	public void setLieuN(String lieuN) {
		this.lieuN = lieuN;
	}
	public String getNumP() {
		return numP;
	}
	public void setNumP(String numP) {
		this.numP = numP;
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
	
}
